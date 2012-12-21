/* Compile with gcc -std=c99 -lpthread -o atomicaction atomicaction.c controller.c -I. */
#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include "atomicaction.h"


void entry_1() 
{
/*	printf("Thread 1 in entry\n");*/
	int r = pthread_mutex_lock(&M.mutex);
/*	printf("Mutex locked by thread 1! r is %d\n", r);*/
	while(M.first_process_active)
		pthread_cond_wait(&M.no_first_process, &M.mutex);
	M.first_process_active = true;
/*	printf("First process now active\n");*/
}

void entry_2() 
{
/*	printf("Thread 2 in entry\n");*/
	int r = pthread_mutex_lock(&M.mutex);
/*	printf("Mutex locked by thread 2! r is %d\n", r);*/
	while(M.second_process_active)
		pthread_cond_wait(&M.no_second_process, &M.mutex);
	M.second_process_active = true;
/*	printf("Second process now active\n");*/
}

void entry_3() 
{
/*	printf("Thread 3 in entry\n");*/
	int r = pthread_mutex_lock(&M.mutex);
/*	printf("Mutex locked by thread 3! r is %d\n", r);*/
	while(M.third_process_active)
		pthread_cond_wait(&M.no_third_process, &M.mutex);
	M.third_process_active = true;
/*	printf("Third process now active\n");*/
}

void exit_1() 
{
	while(!M.second_process_finished)
		pthread_cond_wait(&M.atomic_action_ends2, &M.mutex);
/*	printf("Thread exiting\n");*/
	pthread_cond_signal(&M.atomic_action_ends1);
	pthread_cond_signal(&M.no_first_process);
	M.first_process_active = false;
	pthread_mutex_unlock(&M.mutex);
}

void exit_2()
{
	while(!M.third_process_finished)
		pthread_cond_wait(&M.atomic_action_ends3, &M.mutex);
/*	printf("Thread 2 exiting\n");*/
	pthread_cond_signal(&M.atomic_action_ends2);
	pthread_cond_signal(&M.no_second_process);
	M.second_process_active = false;
	pthread_mutex_unlock(&M.mutex);
}

void exit_3()
{
	while(!M.first_process_finished)
		pthread_cond_wait(&M.atomic_action_ends1, &M.mutex);
/*	printf("Thread 3 exiting\n");*/
	pthread_cond_signal(&M.atomic_action_ends3);
	M.third_process_active = false;
	pthread_cond_signal(&M.no_third_process);
	pthread_mutex_unlock(&M.mutex);
}

void first_thread() 
{
	int result;
	int thread_no = 1;
/*	printf("Inside thread %d!\n", thread_no);*/
/*	printf("Thread %d is %d\n", thread_no, M.first_process_active);*/
	for(int i=0; i<10; i++)
	{
		error = false;
		entry_1(M);
		result = aa(thread_no);
		M.first_process_finished = true;
		exit_1(M);
/*		printf("Thread %d ready to vote!\n", thread_no);*/
		
		/* Syncronization point */
		vote(result, thread_no);
		int rc = pthread_barrier_wait(&M.barr1);
		if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
		{
			printf("Could not wait on barrier\n"); 
			exit(-1);
		}
		if(error == true)
		{
			printf("Thread %d detected error after vote! ERROR OCCURED!\n", thread_no);
			result = backtrack(thread_no, result);
			
			/* Synchronization point */
			rc = pthread_barrier_wait(&M.barr2);
			if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
			{
				printf("Could not wait on barrier\n"); 
				exit(-1);
			}
			printf("Thread %d waiting for other threads after backtrack\n", thread_no);
		}
		else
			increment();
	}
}

void second_thread() 
{
	int result;
	int thread_no = 2;
/*	printf("Inside thread %d!\n", thread_no);*/
/*	printf("Thread %d is %d\n", thread_no, M.second_process_active);*/
	for(int i=0; i<10; i++)
	{
		error = false;
		entry_2(M);
		result = aa(thread_no);
		M.second_process_finished = true;
		exit_2(M);
/*		printf("Thread %d ready to vote!\n", thread_no);*/
		
		/* Syncronization point */
		vote(result, thread_no);
		int rc = pthread_barrier_wait(&M.barr1);
		if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
		{
			printf("Could not wait on barrier\n"); 
			exit(-1);
		}
		if(error == true)
		{
			printf("Thread %d detected error after vote! ERROR OCCURED!\n", thread_no);
			result = backtrack(thread_no, result);
			
			/* Synchronization point */
			rc = pthread_barrier_wait(&M.barr2);
			if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
			{
				printf("Could not wait on barrier\n"); 
				exit(-1);
			}
			printf("Thread %d waiting for other threads after backtrack\n", thread_no);
		}
		else
			increment();	
	}
}

void third_thread() 
{
	int result;
	int thread_no = 3;
/*	printf("Inside thread %d!\n", thread_no);*/
/*	printf("Third thread %d is %d\n", thread_no, M.third_process_active);*/
	for(int i=0; i<10; i++)
	{
		error = false;
		entry_3(M);
		result = aa(thread_no);
		M.third_process_finished = true;
		exit_3(M);
/*		printf("Thread %d ready to vote!\n", thread_no);*/
		
		/* Syncronization point */
		vote(result, thread_no);
		int rc = pthread_barrier_wait(&M.barr1);
		if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
		{
			printf("Could not wait on barrier\n"); 
			exit(-1);
		}
		if(error == true)
		{
			printf("Thread %d detected error after vote! ERROR OCCURED!\n", thread_no);
			result = backtrack(thread_no, result);
		
			/* Synchronization point */
			rc = pthread_barrier_wait(&M.barr2);
			if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
			{
				printf("Could not wait on barrier\n"); 
				exit(-1);
			}
			printf("Thread %d waiting for other threads after backtrack\n", thread_no);
		}
		else
			increment();
	}
}

void increment()
{
	g_var++;
}
/* Initalizes monitor */
void init()
{
	M.first_process_active = false;
	M.second_process_active = false;
	M.third_process_active = false;
	
	M.first_process_finished = false;
	M.second_process_finished = false;
	M.third_process_finished = false;
	pthread_mutex_init(&M.mutex, NULL);

	pthread_cond_init(&M.no_first_process, NULL);
	pthread_cond_init(&M.no_second_process, NULL);
	pthread_cond_init(&M.no_third_process, NULL);
	pthread_cond_init(&M.atomic_action_ends1, NULL);
	pthread_cond_init(&M.atomic_action_ends2, NULL);
	pthread_cond_init(&M.atomic_action_ends3, NULL);
	pthread_barrier_init(&M.barr1, NULL, THREADS);
	pthread_barrier_init(&M.barr2, NULL, THREADS);
}

void main()
{
	g_var = 0;
	error = false;
	pthread_t thread1, thread2, thread3;
		
	/* Initialize monitor */
	printf("\nInitializing monitor...\n");
	init();
	printf("Monitor initialized\n");
	
	printf("g_var is %d\n", g_var);	
	printf("Creating threads...\n\n");
	
	/* Create threads */
	pthread_create(&thread1, NULL, &first_thread, NULL);
	pthread_create(&thread2, NULL, &second_thread, NULL);
	pthread_create(&thread3, NULL, &third_thread, NULL);

	/* Join threads */
	pthread_join(thread1, NULL);
	pthread_join(thread2, NULL);
	pthread_join(thread3, NULL);
	
	printf("g_var is now %d\n", g_var);
	
	exit(0);
}
