#include <stdio.h>
#include <pthread.h>

/* Compile with gcc -lpthread *.c */

int i = 0;

void *increment(void *arg)
{
	int j = 0;
	while (j<10000)
	{
		i++;
		j++;
	}
}

void *decrement(void *arg) 
{
	int j = 0;
	while (j<10000) 
	{
		i--;
		j++;
	}
}

int main(void)
{
	int j = 0;
	pthread_t t1, t2;
	printf("Initial value of i = %d\n", i);
	
	pthread_create(&t1,NULL,increment,"add");
	pthread_create(&t2,NULL,decrement,"subtract");
	
	pthread_join(t1,NULL);
	pthread_join(t2,NULL);
	printf("Final value of i = %d\n", i);
	return 0;
}
	
        
    
