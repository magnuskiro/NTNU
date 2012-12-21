/* Compile with gcc -std=c99 -lpthread -o atomicaction atomicaction.c controller.c -I. */
#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include "atomicaction.h"


// NOTE: TRY THE EXAMPLE WITH ONLY TWO THREADS! IF THAT WORKS, FIND OUT WHY
// AND EXPAND TO THREE THREADS! DON'T STUMBLE AROUND BLIND IN THE DARK!!


pthread_barrier_t barr;
monitor M;

void entry_1(monitor *M) 
{
	printf("Thread 1 in entry\n");
	int r = pthread_mutex_lock(&M->mutex);
	printf("Mutex locked by thread 1! r is %d\n", r);
	/* if true, suspends until conditions are met */
	while(M->first_process_active)
		pthread_cond_wait(&M->no_first_process, &M->mutex);
	M->first_process_active = true;
	printf("First process now active\n");
}

void entry_2(monitor *M) 
{
	printf("Thread 2 in entry\n");
	int r = pthread_mutex_lock(&M->mutex);
	printf("Mutex locked by thread 2! r is %d\n", r);
	/* if true, suspends until conditions are met */
	while(M->second_process_active)
		pthread_cond_wait(&M->no_second_process, &M->mutex);
	M->second_process_active = true;
	printf("Second process now active\n");
}

void entry_3(monitor *M) 
{
	printf("Thread 3 in entry\n");
	int r = pthread_mutex_lock(&M->mutex);
	printf("Mutex locked by thread 3! r is %d\n", r);
	/* if true, suspends until conditions are met */
	while(M->third_process_active)
		pthread_cond_wait(&M->no_third_process, &M->mutex);
	M->third_process_active = true;
	printf("Third process now active\n");
}

void exit_1(monitor *M) 
{
	// TODO
	while(!M->second_process_finished)
		pthread_cond_wait(&M->atomic_action_ends2, &M->mutex);
/*	while(!M->third_process_finished)*/
/*		pthread_cond_wait(&M->atomic_action_ends3, &M->mutex);*/
	pthread_cond_signal(&M->atomic_action_ends1);
	pthread_cond_signal(&M->no_first_process);
	M->first_process_active = false;
	pthread_mutex_unlock(&M->mutex);
}

void exit_2(monitor *M)
{
	while(!M->third_process_finished)
		pthread_cond_wait(&M->atomic_action_ends3, &M->mutex);
/*	while(!M->third_process_finished)*/
/*		pthread_cond_wait(&M->atomic_action_ends3, &M->mutex);*/
	printf("Thread 2 exiting\n");
	pthread_cond_signal(&M->atomic_action_ends2);
	pthread_cond_signal(&M->no_second_process);
	M->second_process_active = false;
	pthread_mutex_unlock(&M->mutex);
	// TODO
}

void exit_3(monitor *M)
{
	printf("Thread 3 exiting\n");
	while(!M->first_process_finished)
		pthread_cond_wait(&M->atomic_action_ends1, &M->mutex);
/*	while(!M->second_process_finished)*/
/*		pthread_cond_wait(&M->atomic_action_ends2, &M->mutex);*/
	pthread_cond_signal(&M->atomic_action_ends3);
	M->third_process_active = false;
	pthread_cond_signal(&M->no_third_process);
	pthread_mutex_unlock(&M->mutex);
	// TODO
}

void first_thread(void* foo) 
{
	monitor* M = (monitor*)foo;
	printf("Inside thread 1!\n");
	printf("Thread 1 is %d\n", &M->first_process_active);
	boolean result;
	for(int i=0; i<10; i++)
	{
/*		M->first_process_finished = false;*/
		entry_1(M);
		aa(1);
		M->first_process_finished = true;
		exit_1(M);
/*		result = vote();*/
/*		if (!result)*/
/*			backtrack();*/
	}
}

void second_thread(void* foo) 
{
	monitor* M = (monitor*)foo;
	printf("Inside thread 2!\n");
	printf("Monitor t is \t %d\n", &M->t);
	boolean result;
	for(int i=0; i<10; i++)
	{
/*		M->second_process_finished = false;*/
		entry_2(M);
		aa(2);
		M->second_process_finished = true;
		exit_2(M);
/*		result = vote();*/
/*		if (!result)*/
/*			backtrack();*/
	}
}

void third_thread(void* foo) 
{
	monitor* M = (monitor*)foo;
	printf("Inside thread 3!\n");
	printf("Third thread is %d\n", &M->third_process_active);
	boolean result;
	for(int i=0; i<10; i++)
	{
/*		M->third_process_finished = false;*/
		entry_3(M);
		aa(3);
		M->third_process_finished = true;
		exit_3(M);
/*		result = vote();*/
/*		if (!result)*/
/*			backtrack();*/
	}
}

monitor init_monitor()
{
	monitor mon = {
		.first_process_active = false,
		.second_process_active = false,
		.third_process_active = false,
		.first_process_finished = false,
		.second_process_finished = false,
		.third_process_finished = false,

/*		pthread_mutexattr_t mutex_att;*/
		.mutex = PTHREAD_MUTEX_INITIALIZER,

/*		pthread_condattr_t con_attr;*/
		.no_first_process = PTHREAD_COND_INITIALIZER,
		.no_second_process = PTHREAD_COND_INITIALIZER,
		.no_third_process = PTHREAD_COND_INITIALIZER,
		.atomic_action_ends1 = PTHREAD_COND_INITIALIZER,
		.atomic_action_ends2 = PTHREAD_COND_INITIALIZER,
		.atomic_action_ends3 = PTHREAD_COND_INITIALIZER,
		.t = 15
	};
	printf("Monitor initialized\n");
	return mon;
}

void main()
{
	g_var = 0;
	pthread_t thread1, thread2, thread3;
	
	/* Barrier initialization */
	if(pthread_barrier_init(&barr, NULL, 3))
		printf("Could not create barrier\n");
	
	/* TODO: INITIALIZE MONITOR */
	monitor M = init_monitor();
	monitor *Mo = malloc(sizeof(monitor));
	Mo = &M;
	printf("First process is %d\n", Mo->first_process_active);
	
	/* Create threads */
	pthread_create(&thread1, NULL, &first_thread, &Mo);
	pthread_create(&thread2, NULL, &second_thread, &Mo);
	pthread_create(&thread3, NULL, &third_thread, &Mo);
	
	
	while(1) {}
	
	pthread_join(thread1, NULL);
	pthread_join(thread2, NULL);
	pthread_join(thread3, NULL);
	
}
