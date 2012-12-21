/*
 * CliServ.h
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */


#ifndef _CLISERV_H_
#define _CLISERV_H_

//________________________________________________________________________

#ifdef __cplusplus
extern "C" 
{
#endif // __cplusplus

//#include <winsock2.h>
//#include <ws2tcpip.h>
//#include <Windows.h>
#include "typedefs.h"
#include <malloc.h>
#include <string.h>
#include "queue.h"
#include "messages.h"
#include <sys/types.h>          /* See NOTES */
#include <sys/socket.h>
#include <netdb.h>

#pragma pack(push,1)


#define		cli_state_init				1
#define		cli_state_create_sck		2
#define		cli_state_connect			3
#define		cli_state_connected			4
#define		cli_state_waiting_list		5
#define		cli_state_chat				6
#define		cli_state_cleanup			7

#define ev_NEW_CLIENT		1
#define ev_NEW_MESSAGE		2

// ________________________________________________________
typedef struct _CLIENT_DESCRIPTOR
{
	DLIST	placeholder;

	QUEUE	queue;

	char	strCliName[512];
}CLIENT_DESCRIPTOR, *PCLIENT_DESCRIPTOR;
// ________________________________________________________
typedef struct _EVENT
{
	DLIST	placeholder;
	
	int		eEventType;
	char	strCliName[512];
	BYTE	bData[1];
}EVENT, *PEVENT;
// ________________________________________________________

	
#pragma pack(pop)

///////////////////////////////////////////////////////////////////////////

#ifdef __cplusplus
} // extern "C"
#endif // __cplusplus

///////////////////////////////////////////////////////////////////////////

#endif // !defined _CLISERV_H_
