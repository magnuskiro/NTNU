#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

#define FIRST 10
#define SECOND 20
#define THREADS 2

typedef unsigned int boolean;
#define false 0
#define true (!false)


pthread_barrier_t barr;
pthread_mutex_t mut = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

// compile with gcc -std=c99 -lpthread wait.c
int g_var = 5;

void add(int i) 
{
	boolean active = 1;
	pthread_mutex_lock(&mut);
/*	while(active == 1)*/
/*	{*/
/*		pthread_cond_wait(&cond, &mut);*/
/*	}*/
	printf("Inside add and g_var is %d\n", g_var);
	if (g_var == i)
	{
		g_var++;
		printf("g_var is now %d\n", g_var);
	}
	active = 0;
	pthread_mutex_unlock(&mut);
}

void * entry_point(void *arg)
{
	int i;
	int j = g_var;
	for (i=0; i<FIRST; i++)
	{ 
		printf("This is thread %d, and iteration %d\n", arg, i);
		add(j);
		j = g_var;
		int rc = pthread_barrier_wait(&barr);
		if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
		{
			printf("Could not wait on barrier\n"); 
			exit(-1);
		}				
	}
	
	printf("Both threads finished!\n");
	int rc = pthread_barrier_wait(&barr);
	if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
	{
		printf("Could not wait on barrier\n"); 
		exit(-1);
	}
	
	for (i=FIRST; i<SECOND; i++)
	{
		printf("This is thread %d, and iteration %d\n", arg, i);
		int rc = pthread_barrier_wait(&barr);
		if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
		{
			printf("Could not wait on barrier\n"); 
			exit(-1);
		}
	}
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
