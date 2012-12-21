/*
 * messages.c
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */

#include "messages.h"
#include <string.h>
#include <malloc.h>

//__________________________________________________________________________________________
/*
 * Summary:      	Prepares a Client registration message that is sent by the Client to
 * 					the Server
 * Parameters:   	C String containing Client's ID / Username
 * Return:       	JSON Object rendered as text that is ready for transfer
 */
char* prepare_cli_reg_mess(const char* strCliId)
{
	char* out;
	cJSON *root,*cli;

	root=cJSON_CreateObject();
	cJSON_AddItemToObject(root, "app_client_registration", cli=cJSON_CreateObject());
	cJSON_AddStringToObject(cli, "client_id", strCliId);

	out=cJSON_Print(root);	cJSON_Delete(root);

	//printf("%s\n", out);

	return out;
}
//__________________________________________________________________________________________
/*
 * Summary:      	Prepares a Client list message that is sent by the Server to
 * 					the Client after the client is Registered or ther's been a change in the list
 * 					of connected clients
 * Parameters:   	Array of connected client IDs/Usernames
 * Return:       	JSON Object rendered as text that is ready for transfer
 */
char* prepare_client_list_message(const char** list)
{
	char *out;
	cJSON *root, *tmp;
	int number = 0;
	root=cJSON_CreateObject();

	for(number = 0; (list[number] != NULL); number++);

	cJSON_AddItemToObject(root, "app_clients", tmp = cJSON_CreateObject());

	cJSON_AddItemToObject(tmp, "list_of_connected_clients", cJSON_CreateStringArray(list, number));

	out=cJSON_Print(root);	cJSON_Delete(root);

	//printf("%s\n", out);

	return out;
}
//__________________________________________________________________________________________
/*
 * Summary:      	Prepares a Chat message that is sent by the Client to the Server or vice - versa
 * Parameters:   	C String designating the Destination Client
 * 					C String designating the Source Client
 * 					C String containing the message itself
 * Return:       	JSON Object rendered as text that is ready for transfer
 */
char* prepare_chat_message(const char* to, const char* from, const char* message)
{
	char *out;
	cJSON *root, *cli;

	root=cJSON_CreateObject();
	cJSON_AddItemToObject(root, "app_chat_message", cli=cJSON_CreateObject());
	cJSON_AddStringToObject(cli, "to", to);
	cJSON_AddStringToObject(cli, "from", from);
	cJSON_AddStringToObject(cli, "message", message);

	out=cJSON_Print(root);	cJSON_Delete(root);

	//printf("%s\n", out);

	return out;
}
//__________________________________________________________________________________________
/*
 * Summary:      	Prepares a Ping message that is sent by the Client to the Server or vice - versa
 * 					when there is no date interchange for some predefined period of time
 * Parameters:   	C String designating the Destination Client (can be a dummy string)
 * 					C String designating the Source Client (can be a dummy string)
 * Return:       	JSON Object rendered as text that is ready for transfer
 */
char* prepare_ping_mesage(char* to, char* from)
{
	char *out;
	cJSON *root, *cli;

	root = cJSON_CreateObject();
	cJSON_AddItemToObject(root, "app_ping_message", cli=cJSON_CreateObject());
	cJSON_AddStringToObject(cli, "to", to);
	cJSON_AddStringToObject(cli, "from", from);

	out=cJSON_Print(root);	cJSON_Delete(root);

	//printf("%s\n", out);

	return out;


}
//__________________________________________________________________________________________
/*
 * Summary:      	Prepares a Ping message that is sent by the Client to the Server or vice - versa
 * 					as a response to a PING request
 * 					when there is no date interchange for some predefined period of time
 * Parameters:   	C String designating the Destination Client (can be a dummy string)
 * 					C String designating the Source Client (can be a dummy string)
 * Return:       	JSON Object rendered as text that is ready for transfer
 */
char* prepare_pong_mesage(char* to, char* from)
{
	char *out;
	cJSON *root, *cli;

	root = cJSON_CreateObject();
	cJSON_AddItemToObject(root, "app_pong_message", cli=cJSON_CreateObject());
	cJSON_AddStringToObject(cli, "to", to);
	cJSON_AddStringToObject(cli, "from", from);

	out=cJSON_Print(root);	cJSON_Delete(root);

	//printf("%s\n", out);

	return out;


}
//__________________________________________________________________________________________
/*
 * Summary:      	Parses the text received from the socket to conclude which type of message has
 * 					been received
 * Parameters:   	C String with the actual message text
 * Return:       	The message type (One of json* constants)
 */
int	get_message_type(char* in)
{

	cJSON* tmp;
	cJSON* obj = cJSON_Parse(in);
	int ret = jsonERROR;

	if(obj == NULL)
	{
		return jsonERROR;
	}

	if((tmp = cJSON_GetObjectItem(obj, "app_client_registration")))
	{
		ret = jsonREG_MESSAGE;
	}
	else if((tmp = cJSON_GetObjectItem(obj, "app_clients")))
	{
		ret = jsonCLI_LIST_MESSAGE;
	}
	else if((tmp = cJSON_GetObjectItem(obj, "app_chat_message")))
	{
		ret = jsonCHAT_MESSAGE;
	}
	else if((tmp = cJSON_GetObjectItem(obj, "app_ping_message")))
	{
		ret = jsonPING_MESSAGE;
	}
	else if((tmp = cJSON_GetObjectItem(obj, "app_pong_message")))
	{
		ret = jsonPONG_MESSAGE;
	}
	else
	{
		ret = jsonERROR;
	}

	cJSON_Delete(obj);

	return ret;
}

//__________________________________________________________________________________________
/*
 * Summary:      	Parses the received Client registration message
 * Parameters:   	C String with the actual message text
 * Return:       	jsonCLI_REG structure containing the Client ID/Username
 */
jsonCLI_REG parse_reg_mess(char* in)
{
	cJSON* tmp; jsonCLI_REG ret;
	cJSON* obj = cJSON_Parse(in);

	tmp = cJSON_GetObjectItem(obj, "app_client_registration");

	tmp = cJSON_GetObjectItem(tmp, "client_id");

	ret.cliid = (char*) malloc(strlen(tmp->valuestring) + 1);

	memcpy(ret.cliid, tmp->valuestring, strlen(tmp->valuestring));

	
	ret.cliid[strlen(tmp->valuestring)] = '\0';

	cJSON_Delete(obj);

	return ret;


}


//__________________________________________________________________________________________
/*
 * Summary:      	Parses the received Client list message
 * Parameters:   	C String with the actual message text
 * Return:       	jsonCLI_LIST structure containing the list of clients as an C String Array and the number of Clients
 */
jsonCLI_LIST parse_cli_list_mess(char* in)
{
	int num, c;

	cJSON* tmp; jsonCLI_LIST ret; cJSON* elem;
	cJSON* obj = cJSON_Parse(in);

	tmp = cJSON_GetObjectItem(obj, "app_clients");

	tmp = cJSON_GetObjectItem(tmp, "list_of_connected_clients");

	num = cJSON_GetArraySize(tmp);

	ret.count = num;

	ret.list = (char**)malloc(sizeof(char*)*num);


	for(c = 0; c < num; c++)
	{
		elem = cJSON_GetArrayItem(tmp, c);

		ret.list[c] = (char*)malloc(strlen(elem->valuestring) + 1);

		memcpy(ret.list[c], elem->valuestring, strlen(elem->valuestring));

	
		ret.list[c][strlen(elem->valuestring)] = '\0';

	}

	cJSON_Delete(obj);

	return ret;

}
//__________________________________________________________________________________________
/*
 * Summary:      	Parses the received Chat message
 * Parameters:   	C String with the actual message text
 * Return:       	jsonCHAT_MSG structure containing the Message Destination and Source ant the actual
 * 					Message Text
 */
jsonCHAT_MSG parse_chat_message(char* in)
{
	jsonCHAT_MSG ret;

	cJSON* tmp, *elem;
	cJSON* obj = cJSON_Parse(in);

	tmp = cJSON_GetObjectItem(obj, "app_chat_message");

	elem = cJSON_GetObjectItem(tmp, "to");

	ret.to = (char*)malloc(strlen(elem->valuestring) + 1);

	strcpy(ret.to, elem->valuestring);

	elem = cJSON_GetObjectItem(tmp, "from");

	ret.from = (char*)malloc(strlen(elem->valuestring) + 1);

	strcpy(ret.from, elem->valuestring);


	elem = cJSON_GetObjectItem(tmp, "message");

	ret.message = (char*)malloc(strlen(elem->valuestring) + 1);

	strcpy(ret.message, elem->valuestring);


	cJSON_Delete(obj);

	return ret;


	
}

//__________________________________________________________________________________________
/*
 * Summary:      	Extracts one valid JSON message from a memory buffer which can contain more
 * 					such messages being either complete or incomplete (data still pending in the system socket buffer)
 * 					JSON messages are delimited by curly brackets "{}"
 * Parameters:   	Pointer to the buffer
 * 					Length of the data in the buffer
 * 					Pointer to the variable holding the remaining bytes in the buffer that are there but haven't been recognized
 * 					as a part of a complete message - when receiving further data from the socket, we must continue at that position
 * Return:       	JSON item in textual form - One complete JSON message ready for parsing
 */
char*	ExtractJSONFromBuffer(char* pRxBuffer, unsigned long dwLen, unsigned long* pUlposition)
{
	int nBrackets = 0;

	int i;
	int	fOneFound = 0;

	char*	pRet = NULL;

	for(i = 0; i < dwLen; i++)
	{
		if(pRxBuffer[i] == '{')	
		{
			nBrackets++;
			fOneFound = 1;
		}

		if(pRxBuffer[i] == '}')	
		{	
			nBrackets--;
		}

		if((nBrackets == 0) && (fOneFound))
		{
			pRet = (char*) malloc((i+2)*sizeof(char));

			memcpy(pRet, pRxBuffer, (i+1));

			pRet[i+1] = '\0';

			// The Buffer is aligned again - Copy the remaining part of the message
			memmove(pRxBuffer, &pRxBuffer[i+1], dwLen - i - 1);

			*pUlposition = dwLen - i - 1;

			break;
		}
	}



	return pRet;

}




