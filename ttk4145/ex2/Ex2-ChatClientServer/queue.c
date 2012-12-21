/*
 * queue.c
 *
 *  Created on: 25. jan. 2012
 *      Author: mladens
 */

#include "queue.h"

typedef void** PPVOID;

//____________________________________________________
int QueueInit(PQUEUE pQueue)
{
	//InitializeCriticalSection(&(pQueue->csLock));
	pthread_mutexattr_init(&(pQueue->scAttr));
	pthread_mutexattr_settype(&(pQueue->scAttr), PTHREAD_MUTEX_RECURSIVE_NP);
	pthread_mutex_init(&(pQueue->csLock), &(pQueue->scAttr));
	//pQueue->hCountSem = CreateSemaphore(NULL, 1, 0x7fffffff, NULL);
	sem_init(&(pQueue->hCountSem), 0, 1);

	sem_wait(&pQueue->hCountSem);

	pQueue->dlQueue.pNext = pQueue->dlQueue.pPrev = &pQueue->dlQueue;

	return 0;
}

//____________________________________________________
int QueueDestroy(PQUEUE pQueue)
{
	PDLIST	pDList;
	void*	pFreed = NULL;

	pthread_mutex_lock(&(pQueue->csLock));

	pDList = pQueue->dlQueue.pPrev;
	while(pDList != &(pQueue->dlQueue))
	{
		pFreed = pDList;
		pDList = pDList->pPrev;
		free(pFreed);
	}
	
	pthread_mutex_unlock(&(pQueue->csLock));
	pthread_mutex_destroy(&(pQueue->csLock));
	sem_close(&pQueue->hCountSem);

	return 0;

}
//____________________________________________________
void QueueInsert(PQUEUE pQueue, void* pData)
{
	PDLIST pNew = (PDLIST)pData;
		

	pthread_mutex_lock(&(pQueue->csLock));

	pNew->pNext = pQueue->dlQueue.pNext;
	pNew->pPrev = &pQueue->dlQueue;

	pQueue->dlQueue.pNext->pPrev = pNew;
	pQueue->dlQueue.pNext = pNew;

	pthread_mutex_unlock(&(pQueue->csLock));

	sem_post(&pQueue->hCountSem);
}

//____________________________________________________

int QueueAdd(PQUEUE pQueue, unsigned long dwDataLength, void* pData)
{
	void*	pNewElem;
	PDLIST	pNew;

	pNewElem = malloc(dwDataLength);

	if(!pNewElem)
	{
		return -1;
	}

	memcpy(pNewElem, pData, dwDataLength);

	pNew = (PDLIST)pNewElem;

	pthread_mutex_lock(&(pQueue->csLock));

	pNew->pNext = pQueue->dlQueue.pNext;
	pNew->pPrev = &(pQueue->dlQueue);

	pQueue->dlQueue.pNext->pPrev = pNew;
	pQueue->dlQueue.pNext = pNew;

	pthread_mutex_unlock(&(pQueue->csLock));

	sem_post(&pQueue->hCountSem);

	return 0;

}

//____________________________________________________
void* QueueRemove(PQUEUE pQueue)
{
	PDLIST	pDList;
	void*	pEvent = NULL;
	
	pthread_mutex_lock(&(pQueue->csLock));

	

	for(pDList = pQueue->dlQueue.pPrev; pDList != &(pQueue->dlQueue); pDList = pDList->pPrev)
	{
		pEvent = pDList;

		pDList->pNext->pPrev = pDList->pPrev;
		pDList->pPrev->pNext = pDList->pNext;

		sem_wait(&pQueue->hCountSem);
		break;
	}

	pthread_mutex_unlock(&(pQueue->csLock));

	return pEvent;

}

//____________________________________________________
int		ObjListInit(POBJLIST pObjList)
{
	pthread_mutexattr_init(&(pObjList->scAttr));
	pthread_mutexattr_settype(&(pObjList->scAttr), PTHREAD_MUTEX_RECURSIVE_NP);
	pthread_mutex_init(&(pObjList->csLock), &(pObjList->scAttr));

	pObjList->dlList.pNext = pObjList->dlList.pPrev = &(pObjList->dlList);

	return 0;
}

//____________________________________________________
void	ObjListAdd(POBJLIST pObjList, PDLIST pNew)
{
	pthread_mutex_lock(&(pObjList->csLock));

	pNew->pNext = pObjList->dlList.pNext;
	pNew->pPrev	= &(pObjList->dlList);

	pObjList->dlList.pNext->pPrev = pNew;
	pObjList->dlList.pNext = pNew;

	pthread_mutex_unlock(&(pObjList->csLock));
}
//____________________________________________________
void	ObjListRemoveObj(POBJLIST pObjList, PDLIST pDeleted)
{

	pthread_mutex_lock(&(pObjList->csLock));
	if((pDeleted->pNext == NULL) || (pDeleted->pPrev == NULL))
	{
		pthread_mutex_unlock(&(pObjList->csLock));
		return;
	}



	pDeleted->pPrev->pNext	= pDeleted->pNext;
	pDeleted->pNext->pPrev	= pDeleted->pPrev;

	pDeleted->pPrev = NULL;
	pDeleted->pNext = NULL;


	pthread_mutex_unlock(&(pObjList->csLock));
}

//____________________________________________________
PDLIST	ObjListGetNext(POBJLIST pObjList, PDLIST pLast)
{
	PDLIST	pRet;

	if(!pObjList)
	{
		return NULL;
	}


	if(pLast == NULL)
	{
		pRet = pObjList->dlList.pPrev;
	}
	else
	{
		pRet = pLast->pPrev;
	}

	if(pRet == &(pObjList->dlList))
	{
		return NULL;
	}
	else
	{
		return pRet;
	}
}

//____________________________________________________

void	ObjListDestroy(POBJLIST pObjList)
{
	pObjList->dlList.pNext = pObjList->dlList.pPrev = &(pObjList->dlList);

	pthread_mutex_destroy(&pObjList->csLock);

	return;
}
//____________________________________________________
void	ObjListRelease(POBJLIST pObjList)
{
	pthread_mutex_unlock(&(pObjList->csLock));
}
//____________________________________________________
void	ObjListLock(POBJLIST pObjList)
{
	pthread_mutex_lock(&(pObjList->csLock));
}

