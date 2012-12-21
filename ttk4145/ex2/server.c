/* Code taken from man getaddrinfo */

#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/socket.h>
#include <netdb.h>

#define BUF_SIZE 500

int main(int argc, char *argv[])
{
    SOCKET = ListenSocket;
    SOCKET = AcceptSocket;
    int retVal;
    BOOL fFound = FALSE;
    
    int mode = 1;
    
    // Address info structures
    struct addrinfo *result = NULL;
    struct addrinfo *ptr = NULL;
    struct addrinfo hints;
    
	if (argc != 2) 
	{
		fprintf(stderr, "Usage: %s port\n", argv[0]);
		exit(EXIT_FAILURE);
	}
	
	memset(&hints, 0, sizeof(struct addrinfo)); /* Initialize to 0 */
	hints.ai_family = AF_UNSPEC;	            /* Allow IPv4 or IPv6 */
	hints.ai_socktype = SOCK_STREAM;	        /* Stream socket */
	hints.ai_flags = AI_PASSIVE;	            /* For wildcard IP address */
	hints.ai_protocol = IPPROTO_TCP;	        /* TCP protocol */
	
	retVal = getaddrinfo(NULL, argv[1], &hints, &results);
	if (retVal != 0) 
	{
		fprintf("getaddrinfo failed with error code: %d\n", retVal);
		exit(EXIT_FAILURE);
	}
	
	/* getaddrinfo() returns a list of address structures.
       Try each address until we successfully bind.
       If socket (or bind) fails, we close the socket
       and try the next address. */
	for (ptr = result; ptr != NULL; ptr = ptr->ai_next) 
	{
		ListenSocket = socket(ptr->ai_family, ptr->ai_socktype, ptr->ai_protocol);
		if (ListenSocket == INVALID_SOCKET)
		    printf("Socket failed with error: %s\n", strerror(errno));
			continue;
		
		// Allow the port to be reused even if it is busy (TIME WAIT State)
		setsocopt(ListenSocket, SOL_SOCKET, SO_REUSEADDR, &mode, sizeof(mode));
		
		// Make the connection - socket address mapping	
		if (bind(ListenSocket, ptr->ai_addr, ptr->ai_addrlen) == 0)
		{
			break;					    /* Success */
		}
		else
		{
		    printf("Bind failed with error: %s\n", strerror(errno));	
		    continue;
		}
		close(ListenSocket);
	}
	
	// Listen for incoming connection requests on the created socket
	if (listen(ListenSocket, SOMAXCONN) == SOCKET_ERROR) {
	    printf("listen failed with error: %s\n", strerror(errno));
	    closesocket(ListenSocket);
	    return NULL;
	}
	
	// Create a socket for accepting incoming requests
	printf("Waiting or client to connect...\n");
	
	// Accept the connections
	// If you have a connection request, accept it, and create a new thread
	// to handle it
	
	while(1)
	{
	    AcceptSocket = accept(ListenSocket, NULL, NULL);
	    if (AcceptSocket == INVALID_SOCKET)
	    {
	        printf("accept failed with error: %s\n", strerror(errno));
	        close(ListenSocket);
	        
	        return NULL;
	    }
	    else
	    {
	        SOCKET* p;
	        pthread_t* pNewThread;
	        printf("Client connected\n");
	        p = (SOCKET*)malloc(sizeof(SOCKET));
	        pNewThread = (pthread_t*)malloc(sizeof(pthread_t));
	        *p = AcceptSocket;
	        
	        // Create thread and pass the SOCKET pointer as a paramter
	        
	        pthread_create(pNewThread, NULL, ServeClient, p);
	        
	    }
	}
	
	// No longer need server socket
	close(ListenSocket);
    freeaddrinfo(result);	
	return NULL;

}
	        
	       
		

