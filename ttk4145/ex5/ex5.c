// compile with gcc -std=c99 -lpthread wait.c
#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

/*************************
	DEFINES
**************************/
#define FIRST 10
#define SECOND 20
#define THREADS 2

typedef unsigned int boolean;
#define false 0
#define true (!false)

/*************************
	TYPEDEF MONITOR
*************************/
/*typedef struct {*/
/*	boolean first_process_active;*/
/*	boolean second_process_active;*/
/*	boolean third_process_active;*/
/*	boolean first_process_finished;*/
/*	boolean second_process_finished;*/
/*	boolean third_process_finished;*/
/*	*/
/*	pthread_mutexattr_t mutex_att;*/
/*	pthread_mutex_t mutex;*/
/*	*/
/*	pthread_condattr_t con_attr;*/
/*	pthread_cond_t no_first_process, no_second_process, no_third_process;*/
/*	pthread_cond_t atomic_action_ends1, atomic_action_ends2, atomic_action_ends3;*/
/*} monitor_struct ;*/

/*monitor_struct monitor;*/

boolean first_process_active = false;
boolean second_process_active = false;
boolean third_process_active = false;
boolean first_process_finished = false;
boolean second_process_finished = false;
boolean third_process_finished = false;

pthread_mutexattr_t mutex_att;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

pthread_condattr_t con_attr;
pthread_cond_t no_first_process, no_second_process, no_third_process = PTHREAD_COND_INITIALIZER;
pthread_cond_t atomic_action_ends1, atomic_action_ends2, atomic_action_ends3 = PTHREAD_COND_INITIALIZER;
	
pthread_barrier_t barr;
/*pthread_mutex_t mut = PTHREAD_MUTEX_INITIALIZER;*/
/*pthread_cond_t cond = PTHREAD_COND_INITIALIZER;*/

int g_var = 5;

// TODO: Figure out how to initalize mutex etc. inside method
/*void init_action()*/
/*{*/
/*	monitor.mutex = pthread_mutex_init(&monitor.mutex, NULL);*/
/*	monitor.no_first_process = PTHREAD_COND_INITIALIZER;*/
/*	monitor.no_second_process = PTHREAD_COND_INITIALIZER;*/
/*	monitor.no_third_process = PTHREAD_COND_INITIALIZER;*/
/*	monitor.atomic_action_ends1 = PTHREAD_COND_INITIALIZER;*/
/*	monitor.atomic_action_ends2 = PTHREAD_COND_INITIALIZER;*/
/*	monitor.atomic_action_ends3 = PTHREAD_COND_INITIALIZER;*/
/*	*/
/*	monitor.first_process_active = false;*/
/*	monitor.second_process_active = false;*/
/*	monitor.third_process_active = false;*/
/*	monitor.first_process_finished = false;*/
/*	monitor.second_process_finished = false;*/
/*	monitor.third_process_finished = false;	*/
/*}*/
	
void add(int i) 
{
	boolean active = 1;
	pthread_mutex_lock(&mutex);
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
	pthread_mutex_unlock(&mutex);
}

void *entry_pint(void *arg) 
{
	PTHREAD_MUTEX_LOCK(mutex);
	while(first_process_active) 
		PTHREAD_COND_WAIT(no_first_process, mutex);
	
	printf("IT'S ALIVE!");
	first_process_active = true;
}

void *exit_point(void *arg) 
{
	while(!second_process_active) 

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
