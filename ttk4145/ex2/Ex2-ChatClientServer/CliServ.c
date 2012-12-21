/*
 * CliServ.c
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */


#include "CliServ.h"
#include <sys/unistd.h>
#include <sys/fcntl.h>
#include <errno.h>
#include <signal.h>
#include <time.h>

// Module globals
// {
//________________________________________________________________________________________________________________
// Global List of all currently connected clients
OBJLIST		g_dlConnectedClients;
//________________________________________________________________________________________________________________
// }
//________________________________________________________________________________________________________________
/*
 * Summary:      	Suspends the current thread
 * Parameters:   	Number of miliseconds the thread should be suspended
 * Return:
 */
void 	SleepEx(unsigned long msec, int dummy)
{
	struct timespec req, rem;

	req.tv_sec = msec / 1000;
	req.tv_nsec = (msec % 1000)*1000000L;

	nanosleep(&req, &rem);

	return;
}
//________________________________________________________________________________________________________________
/*
 * Summary:      	Sends data over a SOCKET
 * 					This is how a decent Send function should look like
 * 					We don't check the amount of data actually send in this project, but sometimes it happens
 * 					that send() sends less data the we told it to sent
 * 					USE THIS IN YOUR PROJECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 					BUILD AN ENTIRE SOCKET LIBRARY (MODULE) WITH METHODS LIKE CREATE_SOCKET(...), RECEIVE(...), SEND(...), CONNECT(...), LISTEN(...), SET_NONBLOCKING()
 * 					SET_BLOCKING(...)
 * Parameters:   	Socket
 * 					Data
 * 					Data length in Bytes
 * Return:
 */
int 	SockSend(int socket, unsigned char* data, unsigned long len)
{
	int ret, sent, tmp;

	ret = 0;

	if(len == 0)
	{
		ret = 0;
	}
	else
	{
		sent = 0;
		ret = 0;

		// Loop while there is still data to be sent!
		while(sent < len)
		{
			tmp = send(socket, &data[sent], len - sent, 0);

			if(tmp < 0)
			{
				// Send Error
				// Exit and return (-1)
				ret = -1;
				break;
			}
			else
			{
				// Add up!
				sent += tmp;
				ret = sent;
			}
		}
	}

	return ret;
}
//________________________________________________________________________________________________________________
/*
 * Summary:      	Set the socket to be non-blocking
 * Parameters:   	Socket descriptor
 * Return:			0 for OK, -1 for Error
 */
int setNonblocking(int fd)
{
    int flags;


    if (-1 == (flags = fcntl(fd, F_GETFL, 0)))
        flags = 0;
    return fcntl(fd, F_SETFL, flags | O_NONBLOCK);

}
//________________________________________________________________________________________________________________
/*
 * Summary:      	Create an event data structure ready to be inserted into the Client Handler Thread IN Queue
 * Parameters:   	Event type
 * 					Client Handler's ID that generated the Event
 * 					Event data
 * 					The length of data in bytes
 * Return:			Pointer to the created event structure on heap
 */
PEVENT CreateCliEvent(int type, char* who, PBYTE bData, DWORD dwSize)
{
	PEVENT ret;

	ret = malloc(sizeof(EVENT) + dwSize);

	memset(ret, 0, sizeof(EVENT) + dwSize);

	ret->eEventType = type;

	strcpy(ret->strCliName, who);

	if(dwSize > 0)
		memcpy(ret->bData, bData, dwSize);


	return ret;
}
//________________________________________________________________________________________________________________
/*
 * Summary:      	Creates a client list from the global object list of currently connected clients
 * Parameters:   	Client ID that is creating the list
 * Return:			Array of Client ID's
 */
char**	CreateClientList(char *myself)
{
	char** ret = NULL;
	PCLIENT_DESCRIPTOR	pIterator = NULL;
	int		i = 0;

	ObjListLock(&g_dlConnectedClients);



	while((pIterator = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients,(PDLIST)pIterator)))
	{


		ret = (char**) realloc(ret, (i+2) * sizeof(char*));

		ret[i] = (char*) malloc(strlen(pIterator->strCliName) + 1);

		strcpy(ret[i], pIterator->strCliName);
		i++;


	}

	// End
	ret[i] = NULL;


	ObjListRelease(&g_dlConnectedClients);

	return ret;
}
//________________________________________________________________________________________________________________
/*
 * Summary:			This thread function handles the established connection with one client application
 * 					The thread receives and sends data to the associated client application
 * 					First time it receives the registration from the client application it sends it
 * 					the list of currently connected clients
 * 					If the client is disconnected it notifies all the other instances of this thread about the change
 * 					and other instances sent the updated client list to client application the are handling
 * 					If a chat message is received, the corresponding client handler is searched for, and if found the message is delivered
 * 					to it
 * 					All communication to all the other instances of this thread is done through a FIFO
 * 					If there is no data interchange between on the socket, a PING message is generated to make conclusion on the
 * 					state of the socket. If still there is no data 2 seconds after the message is send the client is disconnected, removed from the list and
 * 					all the other client handler thread instances are notified via the FIFO. The thread then exits.
 * Parameters:   	Pointer to the Connection Socket with the Client Application
 * Return:			NULL always
 */
void* ServeClient(void *pargs)
{
	// Socket used for communication with the Client application
	SOCKET				sck = (SOCKET)(*((SOCKET*) pargs));
	// Pointer to the Event structure used for notification of other Client handler instances
	PEVENT				pEvent;
	// Counter
	int i;
	// Description of this Client handler
	CLIENT_DESCRIPTOR	cli_desc;
	// Pointer to the Client descriptor used for iteration over the global list of connected clients
	PCLIENT_DESCRIPTOR	pSearch;

	// Instance of chat message
	jsonCHAT_MSG		chat_mess;
	// instance of registration message
	jsonCLI_REG			reg_mess;

	// Double pointer to the client list that is generated from the global double linked list
	char**				cli_list;
	// Variable holding the result from recv() function
	int					by2read;
	// JSON message as text
	char*				out;
	// Variable saying did the client application register itself
	BOOL				freg = FALSE;
	
	// Buffer for socket data
	BYTE				bRxBuffer[1024];

	// New position to read data out from the socket
	// Different than 0 if there is a part of the message in the buffer after parsing, 0 otherwise
	unsigned long		ulNewPos = 0;

	// Variables for timeouts - PING and PONG
	time_t				tLastDataReceived, tLastPingSent;

	// Set this socket to be NONBLOCKING
	// We need that because we can't afford ourselves to be blocked on a recv() call because we also
	// may have something ready for sending
	setNonblocking(sck);

	// Initialize Buffer
	memset(bRxBuffer, 0, sizeof(bRxBuffer));

	// Initialize Input FIFO for receiving notifications from
	// other Client Handlers - Chat messages and Client Connected/Disconnected notifications
	QueueInit(&cli_desc.queue);


	// Initialize timeout variables
	tLastDataReceived 	= time(NULL);
	tLastPingSent		= 0;


	while(1)
	{

		// Read something from socket
		
		by2read = recv(sck, &bRxBuffer[ulNewPos], sizeof(bRxBuffer) - ulNewPos, 0);
		
		// Check socket

		if((by2read == SOCKET_ERROR) && (errno != EAGAIN) && (errno != EWOULDBLOCK))
		{
			// If we have an error and it's not either EAGAIN nor EWOULDBLOCK
			// Socket Failure - Close socket
			shutdown(sck, SHUT_RDWR);
			close(sck);

			// Then remove yourself from the list if there was a registration
			if(freg)
				ObjListRemoveObj(&g_dlConnectedClients, (PDLIST)&cli_desc);

			// Notify all the other Client Handlers that I'm gone via FIFO

			pSearch = NULL;

			ObjListLock(&g_dlConnectedClients);

			while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
			{
				pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

				// Inserting Event to another Client's FIFO
				QueueInsert(&pSearch->queue, pEvent);

			}

			ObjListRelease(&g_dlConnectedClients);

			// Exiting
			return NULL;
		}
		else
		{
			// OK
			if(by2read > 0)
			{
				// We have data on the socket


				BOOL 	fFound = FALSE;
				PCHAR	pMessage;

				// Refresh timeout
				tLastDataReceived = time(NULL);
				tLastPingSent = 0;
				// Iterate while there are messages in the buffer
				while((pMessage = ExtractJSONFromBuffer((char*)bRxBuffer, by2read+ulNewPos, &ulNewPos)))
				{
					// It is now 0, and the remaining data in the buffer is ulNewPosition
					by2read = 0;
					// What kind of message is it?
					switch(get_message_type(pMessage))
					{
					// Registration message
					case jsonREG_MESSAGE:
						reg_mess = parse_reg_mess(pMessage);
						strcpy(cli_desc.strCliName, reg_mess.cliid);
						// Publish yourself
						// Add yourself to the list
						freg = TRUE;
						ObjListLock(&g_dlConnectedClients);
		
						ObjListAdd(&g_dlConnectedClients, (PDLIST)&cli_desc);

						pSearch = NULL;
						i = 0;
						// Notify all the other handlers that there has been a change
						while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
						{
							if(pSearch == &cli_desc)
							{
								continue;
							}

							pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

							QueueInsert(&pSearch->queue, pEvent);

							i++;
						}


						ObjListRelease(&g_dlConnectedClients);

						// Prepare the client list to be sent to the client application
						cli_list = CreateClientList(cli_desc.strCliName);

						out = prepare_client_list_message((const char**)cli_list);

						// Send it!
						if(send(sck, out, strlen(out), 0) == SOCKET_ERROR)
						{
							// If there is an error, close socket, notify others and exit
							shutdown(sck, SHUT_RDWR);
							closesocket(sck);

							ObjListLock(&g_dlConnectedClients);

							ObjListRemoveObj(&g_dlConnectedClients, (PDLIST)&cli_desc);

							pSearch = NULL;

							while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
							{
								pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

								QueueInsert(&pSearch->queue, pEvent);

							}

							ObjListRelease(&g_dlConnectedClients);

							return NULL;
						}


						
						break;
					case jsonCHAT_MESSAGE:
						// Chat message - GET IT!
						chat_mess = parse_chat_message(pMessage);

						ObjListLock(&g_dlConnectedClients);

						pSearch = NULL;

						fFound = FALSE;
						// Find the Client handler that is handling that particular Client
						while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
						{
							if(!strcmp(pSearch->strCliName, chat_mess.to))
							{
								// Found!
								fFound = TRUE;
								break;
							}
						}

						if(fFound)
						{
							// Put the message to FIFO so that the other handler can have it!

							printf("SERVER -> Redirecting: From: %s; To: %s; Mess: <null>.\n", cli_desc.strCliName, pSearch->strCliName);

							pEvent = CreateCliEvent(ev_NEW_MESSAGE, chat_mess.from, (unsigned char*)chat_mess.message, strlen(chat_mess.message)+1);

							QueueInsert(&pSearch->queue, pEvent);

							
						}
						else
						{
							// Not found - Print warning!
							printf("SERVER -> UNKNOWN DESTINATION <%s>\n", chat_mess.to);
						}
						ObjListRelease(&g_dlConnectedClients);


						break;
					case jsonPING_MESSAGE:
						// PING - Reply with PONG
						out = prepare_pong_mesage("N/a", "N/a");
						send(sck, out, strlen(out), 0);
						break;
					case jsonPONG_MESSAGE:
						// Do nothing
						printf("SERVER -> RECEIVED PONG...\n");
						break;
					default:
						// Error in parsing - PRINT WARNING!
						printf("SERVER -> Unknown data received.\n");
						break;
					}

					free(pMessage);
				}

			
			}else
			{
				// If there is no data available
				// Check the elapsed time since we got the last data
				// If it's been more than 10 seconds and no PING was sent before - Send Ping and expect PONG in return if the socket is OK
				if(((time(NULL) - tLastDataReceived) > 10) && !tLastPingSent)
				{
					out = prepare_ping_mesage("N/a", "N/a");

					send(sck, out, strlen(out), 0);

					tLastPingSent = time(NULL);
				}
				else
				{
					// If PING was send and we got nothing in response (Data or PONG)
					// Socket is DEAD, close it, remove, notify, and exit!
					if(tLastPingSent && ((time(NULL) - tLastPingSent) > 2))
					{
						shutdown(sck, SHUT_RDWR);
						closesocket(sck);
						// DEREGISTER
						ObjListLock(&g_dlConnectedClients);
						ObjListRemoveObj(&g_dlConnectedClients, (PDLIST)&cli_desc);

						pSearch = NULL;

						while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
						{
							pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

							QueueInsert(&pSearch->queue, pEvent);

						}

						ObjListRelease(&g_dlConnectedClients);

						printf("No data after ping...\n");

						return NULL;
					}
				}
			}
		}


		// Check In Queue
		// Check FIFO for notifications from other Client handlers
		// Loop while there are notifications pending
		while((pEvent = QueueRemove(&cli_desc.queue)))
		{
			// What is it?
			switch(pEvent->eEventType)
			{
			// Someone was connected/disconnected
			// Send new list to your client
			case ev_NEW_CLIENT:
				cli_list = CreateClientList(cli_desc.strCliName);
				
				out = prepare_client_list_message((const char**)cli_list);


				if(send(sck, out, strlen(out), 0) == SOCKET_ERROR)
				{
					 printf("socket failed with error: %s\n", strerror(errno));

					// DEREGISTER
					ObjListLock(&g_dlConnectedClients);
					ObjListRemoveObj(&g_dlConnectedClients, (PDLIST)&cli_desc);

					pSearch = NULL;

					while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
					{
						pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

						QueueInsert(&pSearch->queue, pEvent);

					}

					ObjListRelease(&g_dlConnectedClients);
					shutdown(sck, SHUT_RDWR);

					closesocket(sck);

					return NULL;
				}


				break;
			case ev_NEW_MESSAGE:
				// A new message for my client
				// Put it to the right format, and send it!
				out = prepare_chat_message(cli_desc.strCliName, pEvent->strCliName, (char*)pEvent->bData);

				if(send(sck, out, strlen(out), 0) == SOCKET_ERROR)
				{

					// DEREGISTER
					ObjListLock(&g_dlConnectedClients);
					ObjListRemoveObj(&g_dlConnectedClients, (PDLIST)&cli_desc);

					pSearch = NULL;

					while((pSearch = (PCLIENT_DESCRIPTOR)ObjListGetNext(&g_dlConnectedClients, (PDLIST)pSearch)))
					{
						pEvent = CreateCliEvent(ev_NEW_CLIENT, pSearch->strCliName, NULL, 0);

						QueueInsert(&pSearch->queue, pEvent);

					}
					ObjListRelease(&g_dlConnectedClients);
					shutdown(sck, SHUT_RDWR);

					closesocket(sck);

					return NULL;
				}

				break;
			default:
				break;
			}
		}


		// Sleep for a while
		SleepEx(20, FALSE);
		
	}

	
	return NULL;

}

//________________________________________________________________________________________________________________
/*
 * Summary:			This thread function handles new connection requests coming from remote client applications
 * Parameters:   	None
 * Return:			NULL always
 */
void*  ServerThreadFunc( void* pArguments )
{

	SOCKET	ListenSocket;
	SOCKET	AcceptSocket;
	int		iRetval;
	BOOL	fFound = FALSE;

	int		iMode = 1;


	// Adress info structures
	struct addrinfo *result = NULL;
    struct addrinfo *ptr = NULL;
    struct addrinfo hints;

    // Initialize to 0
	ZeroMemory( &hints, sizeof(hints) );
	// Specify what kind of connection we are aiming for
	// Address family unspecified - either IPv4 or IPv6
	hints.ai_family = AF_UNSPEC;
	// Socket type - Connection oriented
    hints.ai_socktype = SOCK_STREAM;
    // protocol - TCP
    hints.ai_protocol = IPPROTO_TCP;
    // Server
	hints.ai_flags	= AI_PASSIVE;

	// Get Information
	iRetval = getaddrinfo(NULL, "9009", &hints, &result);
    if ( iRetval != 0 ) {
        printf("getaddrinfo failed with error: %d\n", iRetval);

        return NULL;
    }

	fFound = FALSE;

	// Iterate over all possible options and try to "hook" to one of them
	for(ptr=result; ptr != NULL ;ptr=ptr->ai_next) 
	{
		// Create socket for listening using the addres information
		ListenSocket = socket(ptr->ai_family, ptr->ai_socktype, ptr->ai_protocol);
		if (ListenSocket == INVALID_SOCKET) 
		{
			printf("socket failed with error: %s\n", strerror(errno));

			return NULL;
		}

		// Allow the port to be reused even if it is busy (TIME WAIT State - Remember the lecture we had on socket states!)
		setsockopt(ListenSocket, SOL_SOCKET, SO_REUSEADDR, &iMode, sizeof(iMode));

		// Make the connection - socket address mapping
		if (bind(ListenSocket,
			/*(SOCKADDR *)*/ ptr->ai_addr, ptr->ai_addrlen) == SOCKET_ERROR)
		{
			printf("bind failed with error: %s\n", strerror(errno));

			closesocket(ListenSocket);
			continue;
		}
		else
		{
			fFound = TRUE;
			break;
		}
	}

	if(!fFound)
	{
		return NULL;
	}


    //----------------------
    // Listen for incoming connection requests.
    // on the created socket

	// Start Listening!

    if (listen(ListenSocket, SOMAXCONN) == SOCKET_ERROR) {
        printf("listen failed with error: %s\n", strerror(errno));
        closesocket(ListenSocket);

        return NULL;
    }
    //----------------------
    // Create a SOCKET for accepting incoming requests.

    printf("Waiting for client to connect...\n");

    //----------------------
    // Accept the connections.
    // If you have a connection request, accept it, and create a new thread that will
    // handle the connection. do this forever!
	while(1)
	{
		AcceptSocket = accept(ListenSocket, NULL, NULL);
		if (AcceptSocket == INVALID_SOCKET)
		{
			printf("accept failed with error: %s\n", strerror(errno));
			closesocket(ListenSocket);

			return NULL;
		} 
		else
		{
			SOCKET* p;

			pthread_t* pNewThread;

			printf("Client connected.\n");

			p = (SOCKET*)malloc(sizeof(SOCKET));

			pNewThread = (pthread_t*)malloc(sizeof(pthread_t));

			*p = AcceptSocket;

			// Create thread and pass the SOCKET pointer as a parameter

			pthread_create(pNewThread, NULL, ServeClient, p);
		}
	}

    // No longer need server socket
    closesocket(ListenSocket);


	return NULL;
}

//________________________________________________________________________________________________________________
/*
 * Summary:			This thread function implements the client application
 * 					The client tries to establish a connection to the server, and once when it gets
 * 					the client list sends messages to all clients in the list
 * Parameters:   	Client Description - ClientID / Username
 * Return:			NULL always
 */
void* ClientThreadFunc(void * pargs)
{
	// Connection socket
	SOCKET	ConnectSocket = INVALID_SOCKET;

	// State machine
	int		nState = cli_state_init;
	// Counter, iterator
	int		i;

	// Address info results
	struct addrinfo *result = NULL;

	// Address info hints
    struct addrinfo hints;

    // Receive Buffer
	BYTE	bRxBuffer[1024];

	// Text Json
	char * out;
	// Result from send
	int by_recv;
	// Client List structure
	jsonCLI_LIST cli_list;
	// Chat message structure
	jsonCHAT_MSG  chat_mess;
	// Timeout variables
	time_t 	tLastPingSent, tLastDataReceived;

	// Variable measuring loop iterations
	// to implement periodic sending of messages to other client applications
	int	mess_cnt = 1;

	// Buffer data pointer, the same meaning as within the SERVER Client handler Thread
	unsigned long ulNewPos = 0;

	PCLIENT_DESCRIPTOR	pCli = (PCLIENT_DESCRIPTOR) pargs;

	// Purge Buffer
	memset(bRxBuffer, 0, sizeof(bRxBuffer));

	// Reset Timeouts
	tLastDataReceived = time(NULL);
	tLastPingSent = 0;


	while(1)
	{
		// Go - Initial state is "cli_state_init"!!
		switch(nState)
		{
		case cli_state_init:
			// Get address info
			ZeroMemory( &hints, sizeof(hints) );
			hints.ai_family = AF_UNSPEC;
			hints.ai_socktype = SOCK_STREAM;
			hints.ai_protocol = IPPROTO_TCP;

			if(getaddrinfo("127.0.0.1", "9009", &hints, &result) == SOCKET_ERROR)
			{
				// If error - exit!
				return NULL;
			}
			else
			{
				// Else go to new state!
				nState = cli_state_create_sck;
			}
			break;

		case cli_state_create_sck:
			// Create socket
			ConnectSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);

			if(ConnectSocket == INVALID_SOCKET)
			{
				// If error, go to initial state
				freeaddrinfo(result);
				nState = cli_state_init;
			}
			else
			{
				// If OK, proceed to the next state
				nState = cli_state_connect;
			}

			break;
		case cli_state_connect:
			
			// Connect to Server!
			if(connect(ConnectSocket, result->ai_addr, result->ai_addrlen) == SOCKET_ERROR)
			{
				// If connection failed - Try again!
				nState = cli_state_connect;
			}
			else
			{
				// Connection is established - Set the socket to NONBLOCKING!
				nState = cli_state_connected;
				setNonblocking(ConnectSocket);
				// Reset Timeouts
				tLastDataReceived = time(NULL);
				tLastPingSent = 0;
			}

			break;

		case cli_state_connected:

			// Connected - Register yourself!
			out = prepare_cli_reg_mess(pCli->strCliName);

			if(send(ConnectSocket, out, strlen(out), 0) == SOCKET_ERROR)
			{
				// If error - Clean up!
				nState = cli_state_cleanup;
			}
			else
			{
				// Go to next state
				nState = cli_state_chat;
				// Purge buffer and reset the pointer
				memset(bRxBuffer, 0, sizeof(bRxBuffer));
				ulNewPos = 0;
			}

			break;
		case cli_state_chat:

			// Receive data!
			by_recv = recv(ConnectSocket, &bRxBuffer[ulNewPos], sizeof(bRxBuffer)-ulNewPos, 0);

			if((by_recv == SOCKET_ERROR) && (errno != EAGAIN) && (errno != EWOULDBLOCK))
			{
				// If error!
				nState = cli_state_cleanup;
				break;
			}
			else if(by_recv > 0)
			{
				// Something received!
				PCHAR pMessage;
				// Reset timeouts!
				tLastDataReceived = time(NULL);
				tLastPingSent = 0;
				// Parse messages!
				while((pMessage = ExtractJSONFromBuffer((char*)bRxBuffer, by_recv + ulNewPos, &ulNewPos)))
				{

					by_recv = 0;

					if(get_message_type(pMessage) == jsonCLI_LIST_MESSAGE)
					{
						// Got client list!
						cli_list = parse_cli_list_mess(pMessage);

						printf("Client %s received list of connected clients->\n", pCli->strCliName);
						for(i = 0; i < cli_list.count; i++)
						{
							printf("\t%s\n", cli_list.list[i]);
						}
					}
					else if(get_message_type(pMessage) == jsonCHAT_MESSAGE)
					{
						// Got chat message!
						chat_mess = parse_chat_message(pMessage);

						printf("RX -> To: %s; From: %s; Mess: %s\n", pCli->strCliName, chat_mess.from, chat_mess.message);
					}
					else if(get_message_type(pMessage) == jsonPING_MESSAGE)
					{
						// Got Ping - Respond with PONG!
						out = prepare_pong_mesage("N/a", "N/a");
						send(ConnectSocket, out, strlen(out), 0);
					}
					else if(get_message_type(pMessage) == jsonPONG_MESSAGE)
					{
						// Got PONG!
						printf("CLIENT -> RECEIVED PONG...\n");
					}
					else
					{
						// Unknown data - Print warning!
						printf("%s: Unknown message received\n", pCli->strCliName);
					}

					free(pMessage);
				}


			}
			else
			{
				// Nothing in the socket buffer - Check timeout!
				if(((time(NULL) - tLastDataReceived) > 10) && !tLastPingSent)
				{
					// Send ping if we have more than 10 seconds and no PING Sent within these 10 seconds!
					out = prepare_ping_mesage("N/a", "N/a");

					send(ConnectSocket, out, strlen(out), 0);

					tLastPingSent = time(NULL);
				}
				else
				{
					// Ping sent
					if(tLastPingSent && ((time(NULL) - tLastPingSent) > 2))
					{
						// Ping sent, but nothing in response for at least 2 seconds!
						// Close Socket and reinitialize!
						shutdown(ConnectSocket, SHUT_RDWR);
						closesocket(ConnectSocket);


						nState = cli_state_cleanup;

						printf("No data after ping...\n");
					}
				}
			}

			// Every 4 seconds generate message for each client from the list!
			// 200 * 20 msec = 4000 msec = 4 sec

			if(mess_cnt++ > 200)
			{
				mess_cnt = 0;
				for(i = 0; i < cli_list.count; i++)
				{
					if(!strcmp(cli_list.list[i], pCli->strCliName))
					{
						// Don't sent to yourself!
						continue;
					}
					else
					{
						char tmp[512];
						int  nSent;

						sprintf(tmp, "Message to %s from %s\n", cli_list.list[i], pCli->strCliName);

						printf("TX -> From: %s; To: %s; Mess: %s\n", pCli->strCliName, cli_list.list[i], tmp);

						out = prepare_chat_message(cli_list.list[i], pCli->strCliName, tmp);

						nSent = send(ConnectSocket, out, strlen(out), 0);

						if(nSent == SOCKET_ERROR)
						{
							printf("CLIENT -> Send() Error\n");
							nState = cli_state_cleanup;
						}
						else if(nSent != strlen(out))
						{
							printf("CLIENT -> Warning (Sent: %d, ToSend: %d)\n", nSent, (int)strlen(out));
						}
						else if(nSent == 0)
						{
							printf("CLIENT -> Warning\n");
						}
		
					}
				}
			}
			
			break;
		case cli_state_cleanup:
			// Cleanup!
			// Close!
			shutdown(ConnectSocket, SHUT_RDWR);
			closesocket(ConnectSocket);
			freeaddrinfo(result);

			nState = cli_state_init;
			break;
		default:
			printf("Client -> Unallowed state!\n");
			break;
		}

		// Rest a while not to overload the CPU!
		SleepEx(20, FALSE);
	}

	return NULL;
}




int main(int argc, char** argv)
{

	CLIENT_DESCRIPTOR	cli1;

	pthread_t			hsrv, hcli1;

	if(argc != 2)
	{
		printf("Error: Start the application like this:\n\t\"./Ex2-ChatClientServer SERVER\" if it is the SERVER or\n\t\"./Ex2-ChatClientServer username\" if it is the CLIENT.\n");
		return 1;
	}

	// VERY IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// Socket failures generate SIGPIPE signal when issuing a send() call
	// which will crash your application if you don have a signal handler
	// We won't implement a signal handler, so we'll just tell the OS to ignore the signal!
	// The same can be achieved by setting MSG_NOSIGNAL flag in send() call like this
	// send(sck, data, len, MSG_NOSIGNAL)
	//signal(SIGPIPE, SIG_IGN);

	// If the application was started with the command line parameter "SERVER"
	// Start Server!

	if(!strcmp(argv[1], "SERVER"))
	{
		ObjListInit(&g_dlConnectedClients);


		pthread_create(&hsrv, NULL, ServerThreadFunc, NULL);


	}
	else
	{
		// Else - Start Client with the ClientID/Username fro the command line!
		strcpy(cli1.strCliName, argv[1]);
		pthread_create(&hcli1, NULL, ClientThreadFunc, &cli1);

	}

	while(1)
	{
		// Loop forever!
		SleepEx(1000, FALSE);
	}
	
	return 0;
}
