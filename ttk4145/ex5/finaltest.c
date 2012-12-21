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

// remove = 
typedef struct monitor {
	boolean first_process_active;
	boolean second_process_active;
	boolean first_process_finished;
	boolean second_process_finished;

/*	pthread_mutexattr_t mutex_att;*/
	pthread_mutex_t mutex;

/*	pthread_condattr_t con_attr;*/
	pthread_cond_t no_first_process, no_second_process;
	pthread_cond_t atomic_action_ends1, atomic_action_ends2;
	
/*	pthread_barrier_t barr;*/
	int t;
} monitor;

void first_thread();
void second_thread();

pthread_barrier_t barr;
int g_var = 5;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
monitor mon;
boolean[3] tracker;


monitor init_monitor(monitor *M)
{
/*	monitor mon = {*/
/*		.first_process_active = false,*/
/*		.second_process_active = false,*/
/*		.first_process_finished = false,*/
/*		.second_process_finished = false,*/

/*		pthread_mutexattr_t mutex_att;*/
/*		.mutex = PTHREAD_MUTEX_INITIALIZER,*/

/*		pthread_condattr_t con_attr;*/
/*		.no_first_process = PTHREAD_COND_INITIALIZER,*/
/*		.no_second_process = PTHREAD_COND_INITIALIZER,*/
/*		.atomic_action_ends1 = PTHREAD_COND_INITIALIZER,*/
/*		.atomic_action_ends2 = PTHREAD_COND_INITIALIZER,*/
/*		.t = 15*/
/*		pthread_barrier_t barr;*/
/*	};*/

	M->first_process_active = false;
	
	return mon;
}


void entry_1(int *M)
{
	printf("Inside entry_1\n");
	PTHREAD_MUTEX_LOCK(&M->mutex);
	while(M->first_process_active)
		PTHREAD_COND_WAIT(&M->no_first_process, &M->mutex);

	M->first_process_active = true;
	
}

void entry_2(int *M) 
{
	printf("Inside entry_2\n");
	PTHREAD_MUTEX_LOCK(&M->mutex);
	while(M->second_process_active)
		PTHREAD_COND_WAIT(&M->no_second_process, &M->mutex);

	M->second_process_active = true;
}

void entry_3(int *M) 
{
	printf("Inside entry_3\n");
	PTHREAD_MUTEX_LOCK(&M->mutex);
	while(M->thirds_process_active)
		PTHREAD_COND_WAIT(&M->no_third_process, &M->mutex);

	M->third_process_active = true;
}

void exit_1()
{
	M->first_process_active = false;
	PTHREAD_MUTEX_UNLOCK(&M->mutex);
	int rc = pthread_barrier_wait(&barr);
	if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
	{
		printf("Could not wait on barrier\n"); 
		exit(-1);
	}
	printf("Thread 1 waiting for other threads\n");
/*	while(!M->second_process_active)*/
/*		PTHREAD_COND_WAIT(&M->atomic_action_ends2, &M->mutex);*/

/*	PTHREAD_COND_SIGNAL(&M->atomic_action_ends1);*/
/*	M->first_process_active = false;*/
/*	PTHREAD_COND_SIGNAL(&M->no_first_process);*/
/*	PTHREAD_MUTEX_UNLOCK(&M->mutex);*/
}

void exit_2()
{
	M->second_process_active = false;
	PTHREAD_MUTEX_UNLOCK(&M->mutex);
	int rc = pthread_barrier_wait(&barr);
	if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
	{
		printf("Could not wait on barrier\n"); 
		exit(-1);
	}
	printf("Thread 2 waiting for other threads\n");
/*	while(!M->second_process_active)*/
/*		PTHREAD_COND_WAIT(&M->atomic_action_ends2, &M->mutex);*/

/*	PTHREAD_COND_SIGNAL(&M->atomic_action_ends1);*/
/*	M->first_process_active = false;*/
/*	PTHREAD_COND_SIGNAL(&M->no_first_process);*/
/*	PTHREAD_MUTEX_UNLOCK(&M->mutex);*/
}

void exit_3()
{
	
/*	while(!M->second_process_active)*/
/*		PTHREAD_COND_WAIT(&M->atomic_action_ends2, &M->mutex);*/

/*	PTHREAD_COND_SIGNAL(&M->atomic_action_ends1);*/
/*	M->first_process_active = false;*/
/*	PTHREAD_COND_SIGNAL(&M->no_first_process);*/
/*	PTHREAD_MUTEX_UNLOCK(&M->mutex);*/
}


void print() 
{
	printf("%d\n", g_var);
}


void first_thread(monitor *M)
{
	int local;
	printf("ja %d", M->t);
	boolean failed = false;
	for(int i=0; i<10; i++) 
	{
		entry_1(M);
		if(rand()%10) 
		{
			failed = true;
			prinf("First thread failed to compute new value\n");
		}
		else 
		{
			local = g_var;
			g_var++;
			failed = false;
		}
		tracker[0] = failed;		
		exit_1(M);
	}	
}


void second_thread(monitor *M)
{
	int local;
	boolean failed = false;
	for(int i=0; i<10; i++) 
	{
		entry_2(M);
		if(rand()%10)
		{
			failed = true;
			printf("Second thread failed to compute new value\n");
		}
		else
		{
			local = g_var;
			g_var++;
			failed = false;
		}
		tracker[1] = failed;
		exit_2(M);
	}
}
int main()
{
	pthread_t thread1, thread2, thread3;
	
	// Barrier init
	if(pthread_barrier_init(&barr, NULL, THREADS))
	{
		printf("Could not create barrier\n");
		return -1;
	}
	
	monitor *M = malloc(sizeof(monitor));
/*	*M = init_monitor(*M);*/
	M->first_process_active = false;
	pthread_create(&thread1, NULL, &first_thread, *M);
	pthread_create(&thread2, NULL, &second_thread, *M);
/*	pthread_create(&thread3, NULL, &entry_3, M);*/
	
	while(1)
	{
	}
	printf("%d\n", g_var);

	pthread_join(thread1, NULL);
	pthread_join(thread2, NULL);
	pthread_join(thread3, NULL);
}
