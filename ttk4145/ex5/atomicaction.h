#define _XOPEN_SOURCE 600
#ifndef atomicaction.h	
#define atomicaction.h

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

typedef unsigned int boolean;
#define false 0
#define true (!false)

#define THREADS 3

int g_var;
boolean error;

typedef struct {
	boolean first_process_active;
	boolean second_process_active;
	boolean third_process_active;
	
	boolean first_process_finished;
	boolean second_process_finished;
	boolean third_process_finished;
	
	pthread_mutexattr_t mutex_att;
	pthread_mutex_t mutex;
	
	pthread_condattr_t con_attr;
	
	pthread_cond_t no_first_process;
	pthread_cond_t no_second_process;
	pthread_cond_t no_third_process;
	
	pthread_cond_t atomic_action_ends1;
	pthread_cond_t atomic_action_ends2;
	pthread_cond_t atomic_action_ends3;
	pthread_barrier_t barr1;
	pthread_barrier_t barr2;
} monitor;

monitor M;
void first_thread();
void second_thread();

#endif
	
