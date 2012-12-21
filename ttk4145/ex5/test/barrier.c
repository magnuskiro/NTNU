#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

#define FIRST 10
#define SECOND 20
#define THREADS 5h

pthread_barrier_t barr;
pthread_mutex_t mut = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

int g_var = 5;

void add(int i) 
{
	bool active = true;
	pthread_mutex_lock(&mut);
	while(active)
	{
		pthread_cond_wait();
	}
	if (g_var == i)
		g_var++;
	active = false;
}

void * entry_point(void *arg)
{
	int i;
	for (i=0; i<FIRST; i++) 
		printf("This is thread %d, and iteration %d\n", arg, i);
	
	// Sync point
	int rc = pthread_barrier_wait(&barr);
	if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
	{
		printf("Could not wait on barrier\n"); 
		exit(-1);
	}
	
	for (i=FIRST; i<SECOND; i++)
		printf("This is thread %d, and iteration %d\n", arg, i);
}

int main()
{
	pthread_t thr[THREADS];
	
	// Barrier init
	if(pthread_barrier_init(&barr, NULL, THREADS))
	{
		printf("Could not create barrier\n");
		return -1;
	}
	
	for(int i=0; i<THREADS; i++)
	{
		if(pthread_create(&thr[i], NULL, &entry_point, (void*)i))
		{
			printf("Could not create thread %d\n", i);
			return -1;
		}
	}
	
	for(int i=0; i<THREADS; i++)
	{
		if(pthread_join(thr[i], NULL))
		{
			printf("Could not join thread %d\n", i);
			return -1;
		}
	}
	return 0;
}
