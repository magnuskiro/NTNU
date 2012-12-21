#define _XOPEN_SOURCE 500
#include <unistd.h>
#include  <stdio.h>
#include  <sys/types.h>
#include  <signal.h>
#include  <sys/ipc.h>
#include  <sys/shm.h>
#include <string.h>

int   ShmID;      
pid_t *ShmPTR;    

void main(int argc, char *argv[]) 
{
	char *str1 = "master";
	char *str2 = "slave";
	if(argc == 2)
		printf("The argument supplied is %s\n", argv[1]);
	else if(argc > 2) 
	{
		printf("Too many arguments\n");
		exit(0);
	}
	else
	{
		printf("One argument expected (slave/master)\n");
		exit(0);
	}
	if(strcmp(argv[1], str1) == 0)
	{
		printf("This instance of the program will take the role as master\n");
		master();
	} 
	else if (strcmp(argv[1], str2) == 0) 
	{
		printf("This instance of the program will take the role as slave\n");
		slave();
	}
}


void master()
{
	void  SIGINT_handler(int);   
	void  SIGQUIT_handler(int); 
/*	void SIGQUIT_handler();*/

    int   i;
    pid_t pid = getpid();
    key_t MyKey;
	printf("Master started");
    if (signal(SIGINT, SIGINT_handler) == SIG_ERR) {
         printf("SIGINT install error\n");
         exit(1);
    }
    if (signal(SIGQUIT, SIGQUIT_handler) == SIG_ERR) {
         printf("SIGQUIT install error\n");
         exit(2);
    }

    MyKey   = 1234;    
    ShmID   = shmget(MyKey, sizeof(pid_t), IPC_CREAT | 0666);
    ShmPTR  = (pid_t *) shmat(ShmID, NULL, 0);
    *ShmPTR = pid;               

    for (i = 0; ; i++) {        
         printf("From process %d: %d\n", pid, i);
         sleep(1);
    }
}

void  slave()
{
    pid_t   pid;
    key_t MyKey;
    int   ShmID;
    pid_t *ShmPTR2;
    char  line[100], c;
    int   i;
	printf("Slave started\n");  
    MyKey   = 1234;  
    printf("Slave started 1\n");        
    ShmID   = shmget(MyKey, sizeof(pid_t), 0666);
    printf("Slave started 2\n");  
    ShmPTR2  = (pid_t *) shmat(ShmID, NULL, 0);
    printf("Slave started 3\n");  
    pid     = *ShmPTR2;     
    printf("Slave started 4\n");             
    shmdt(ShmPTR);  
    printf("Slave started 5\n");    
    printf("pid %d\n", pid);
	union sigval sval;
    sval.sival_int = 666;  
    printf("dvla %d\n", sval.sival_int);

    while (1) {                       
         printf("Want to interrupt the other guy or kill it (i or k)? ");
         gets(line);
         for (i = 0; !(isalpha(line[i])); i++)
              ;
              c = line[i];
         if (c == 'i' || c == 'I') {  
              kill(pid, SIGINT);
              printf("Sent a SIGINT signal\n");
         }
         else if (c == 'k' || c == 'K') {
              printf("About to send a SIGQUIT signal\n");
              //kill(pid, SIGQUIT);     
              sigqueue(pid, SIGQUIT, sval);
              printf("Done.....\n");
              break;
/*              master();*/
/*              exit(0);*/
         }
         else
              printf("Wrong keypress (%c).  Try again\n", c);
    }
    master();
/*    system("./a.out master");*/
}

void  SIGINT_handler(int sig)
{
     signal(sig, SIG_IGN);
     printf("From SIGINT: just got a %d (SIGINT ^C) signal\n", sig);
     signal(sig, SIGINT_handler);
/*     system("./caesar");*/
}

void  SIGQUIT_handler(int sig)
{
     signal(sig, SIG_IGN);
     printf("From SIGQUIT: just got a %d (SIGQUIT ^\\) signal"
                          " and is about to quit\n", sig);
     shmdt(ShmPTR);
     shmctl(ShmID, IPC_RMID, NULL);
/*     system("./caesar");*/
     exit(3);
}
