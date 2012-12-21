/*
 * messages.h
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */

#ifndef _MESSAGES_H_
#define _MESSAGES_H_

//________________________________________________________________________

#ifdef __cplusplus
extern "C" 
{
#endif // __cplusplus

#include <stdio.h>
#include "cJSON.h"
//#include <Windows.h>

#pragma pack(push,1)

// Defines
// {
#define		jsonERROR				-1
#define		jsonREG_MESSAGE			1
#define		jsonCLI_LIST_MESSAGE	2
#define		jsonCHAT_MESSAGE		3
#define 	jsonPING_MESSAGE		4
#define 	jsonPONG_MESSAGE		5

//_____________________________________________________________
typedef struct _jsonGENERIC_M
{
	int				eMessType;
	unsigned char	bData[1];	
}jsonGENERIC_M, *jsonPGENERIC_M;
//_____________________________________________________________

typedef struct _jsonCHAT_MESSAGE
{
	char* from;
	char* to;
	char* message;

}jsonCHAT_MSG, *jsonPCHAT_MSG;
//_____________________________________________________________
typedef struct _jsonCLI_LIST
{
	char**	list;
	int	   	count;
}jsonCLI_LIST, *jsonPCLI_LIST;
//_____________________________________________________________
typedef struct _jsonCLI_REG
{
	char*	cliid;
}jsonCLI_REG, *jsonPCLI_REG;
//_____________________________________________________________
// }

char* prepare_cli_reg_mess(const char* strCliId);
char* prepare_client_list_message(const char** list);
char* prepare_chat_message(const char* to, const char* from, const char* message);
char* prepare_ping_mesage(char* to, char* from);
char* prepare_pong_mesage(char* to, char* from);

int				get_message_type(char* in);

jsonCLI_REG		parse_reg_mess(char* in);

jsonCLI_LIST	parse_cli_list_mess(char* in);

jsonCHAT_MSG parse_chat_message(char* in);

char*	ExtractJSONFromBuffer(char* pRxBuffer, unsigned long dwLen, unsigned long* pUlposition);


#pragma pack(pop)

#ifdef __cplusplus
} // extern "C"
#endif // __cplusplus

///////////////////////////////////////////////////////////////////////////

#endif // !defined _QUEUE_H_
