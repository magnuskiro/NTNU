/*
 * queue.h
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */

#ifndef _QUEUE_H_
#define _QUEUE_H_

//________________________________________________________________________

#ifdef __cplusplus
extern "C" 
{
#endif // __cplusplus

//#include <Windows.h>
#include <semaphore.h>
#include <pthread.h>
#include <malloc.h>
#include <string.h>

#pragma pack(push,1)

// Definitions

typedef struct _DLIST
{
	struct _DLIST *pNext;
	struct _DLIST *pPrev;
}DLIST, *PDLIST;

typedef struct _QUEUE
{
	sem_t				hCountSem;
	pthread_mutex_t		csLock;
	pthread_mutexattr_t	scAttr;
	DLIST				dlQueue;
}QUEUE, *PQUEUE;

typedef struct _OBJLIST
{
	DLIST				dlList;
	pthread_mutex_t		csLock;
	pthread_mutexattr_t	scAttr;

}OBJLIST, *POBJLIST;


// Methods
// Initialize Queue
int QueueInit(PQUEUE pQueue);
// Destroy it
int QueueDestroy(PQUEUE pQueue);
// Add event - data
int QueueAdd(PQUEUE pQueue, unsigned long dwDataLength, void* pData);
// Queue Insert
void QueueInsert(PQUEUE pQueue, void* pData);
// Remove event - data
void* QueueRemove(PQUEUE pQueue);

// Initialize List
int		ObjListInit(POBJLIST pObjList);
// Add Object
void	ObjListAdd(POBJLIST pObjList, PDLIST pNew);
// Remove Object
void	ObjListRemoveObj(POBJLIST pObjList, PDLIST pDeleted);
// GetNext
PDLIST	ObjListGetNext(POBJLIST pObjList, PDLIST pLast);
// Destroy
void	ObjListDestroy(POBJLIST pObjList);
// ObjListLock
void	ObjListLock(POBJLIST pObjList);
// ObjListRelease
void	ObjListRelease(POBJLIST pObjList);




#pragma pack(pop)

///////////////////////////////////////////////////////////////////////////

#ifdef __cplusplus
} // extern "C"
#endif // __cplusplus

///////////////////////////////////////////////////////////////////////////

#endif // !defined _QUEUE_H_

