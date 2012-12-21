/*
 * typedefs.h
 *
 *  Created on: Jan 30, 2012
 *      Author: student
 */

#ifndef TYPEDEFS_H_
#define TYPEDEFS_H_

#include <unistd.h>


typedef int		BOOL;

#define FALSE	0
#define TRUE	1


typedef int 	SOCKET;
typedef unsigned long		DWORD;
typedef char* 	PCHAR;
typedef unsigned	char	BYTE;
typedef BYTE*	PBYTE;
typedef void 	VOID;
typedef VOID*	PVOID;

#define SOCKET_ERROR	-1
#define INVALID_SOCKET	-1

#define closesocket(a) 	close(a)


#define ZeroMemory(a,b)		memset(a, 0, b)



#endif /* TYPEDEFS_H_ */
