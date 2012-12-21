#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include "atomicaction.h"

int aa(int thread_no)
{
	int local;
	int global;
/*	printf("Thread %d has entered atomic action\n", thread_no);*/
	boolean failed = false;
	sleep(1);
	
	if(rand()%10 == 0)
	{
		local = g_var;
		failed = true;
		printf("Thread %d failed to compute new value ", thread_no);
		printf("Computed new value as %d\n", local);
		return local;
	}
	else
	{
		local = g_var;
		local++;
/*		g_var++;*/
/*		global = g_var;*/
		failed = false;
	}
	printf("Thread %d computed new value as %d\n", thread_no, local);
	return local;
}

void vote(int computed_value, int thread_no)
{
	printf("Thread %d voting\n", thread_no);
	if(computed_value != (g_var + 1))
		error = true;
	return;
}

void backtrack(int thread_no, int result)
{
	printf("Thread %d got result %d, expected %d\n", thread_no, result, (g_var+1));
	result = g_var;
	return result;
}
