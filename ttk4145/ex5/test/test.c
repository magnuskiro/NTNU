#define _XOPEN_SOURCE 600

#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>


#define THREADS 3
#define FALSE -1
#define TRUE 1

// Barrier variable
pthread_barrier_t barr;

// failsafe variable
int failsafe = 0;

// threads list.
pthread_t thr[THREADS];

// voting counter
int counter = 0; 

// rollback counter
int rollback = 0; 

// må kanskje være en egen klasse som har en accept broadcast funksjon som håndterer eventuelle rollbacks. 
void * algorithm_thread(void *arg)
{
    int var = 0; 
    for(int row = 0; row < THREADS; row++)
    {
        //update the variable
        var = failsafe + 1; 
        printf("thread %d - var %d\n", (int)arg, var);
        
        //waiting
        int rc = pthread_barrier_wait(&barr);
        if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
        {
            printf("Could not wait on barrier\n");
            exit(-1);
        }
        printf("second\n");
   /*     
        //voting
        if(vote(var)==-1)
        {
            rollback++;
        }
     */   
        // waiting
        rc = pthread_barrier_wait(&barr);
        if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
        {
            printf("Could not wait on barrier\n");
            exit(-1);
        }
        printf("third\n");
       /* 
        // rollback?
        if(rollback!=0)
        {
            printf("rolling back");
            var = failsafe;
        }*/
        
        rc = pthread_barrier_wait(&barr);
        if(rc != 0 && rc != PTHREAD_BARRIER_SERIAL_THREAD)
        {
            printf("Could not wait on barrier\n");
            exit(-1);
        }
    }

}

int vote(int var)
{
    if(var != failsafe)
    {
        return -1; // broadcast rollback. 
    }
    else
    {
        if(counter == THREADS)
        {
            failsafe = var;
        }
        counter++;
        return 1; 
    }
}

int main(int argc, char **argv)
{
    // Barrier initialization
    if(pthread_barrier_init(&barr, NULL, THREADS))
    {
        printf("Could not create the barrier\n");
        return -1;
    }
    
    for(int i = 0; i < THREADS; ++i)
    {
        if(pthread_create(&thr[i], NULL, &algorithm_thread, (void*)i))
        {
            printf("Could not create thread %d\n", i);
            return -1;
        }
    }

    for(int i = 0; i < THREADS; ++i)
    {
        if(pthread_join(thr[i], NULL))
        {
            printf("Could not join thread %d\n", i);
            return -1;
        }
    }

    printf("Finished \n");
    return 0;
}
