#include <stdio.h>
#include <pthread.h>

typedef void* ThreadParam;
//typedef void* (*Thread)(void*);

void *print_number(int *num) {
    int n = (int)num;
    while (1) {
        printf("Tallet er: %d\n", n);
        sleep(1);
    }
}

void start_thread(int tall) {
	pthread_t t;
	pthread_create(&t, NULL, print_number, (void *)tall);
}


int main() {
	start_thread(123);
	start_thread(321);

	pthread_exit(NULL);
}

