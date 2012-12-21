#define _XOPEN_SOURCE 500
#include <unistd.h>
#include  <stdio.h>
#include  <sys/types.h>
#include  <signal.h>
#include  <sys/ipc.h>
#include  <sys/shm.h>

void  SIGINT_handler(int);   
/*void  SIGQUIT_handler(int); */
void SIGQUIT_handler();

int   ShmID;      
pid_t *ShmPTR;    

void main(void)
{
     int   i;
     pid_t pid = getpid();
     key_t MyKey;

     if (signal(SIGINT, SIGINT_handler) == SIG_ERR) {
          printf("SIGINT install error\n");
          exit(1);
     }
     if (signal(SIGQUIT, SIGQUIT_handler) == SIG_ERR) {
          printf("SIGQUIT install error\n");
          exit(2);
     }

     MyKey   = ftok(".", 's');    
     ShmID   = shmget(MyKey, sizeof(pid_t), IPC_CREAT | 0666);
     ShmPTR  = (pid_t *) shmat(ShmID, NULL, 0);
     *ShmPTR = pid;               

     for (i = 0; ; i++) {        
          printf("From process %d: %d\n", pid, i);
          sleep(1);
     }
}

void  SIGINT_handler(int sig)
{
     signal(sig, SIG_IGN);
     printf("From SIGINT: just got a %d (SIGINT ^C) signal\n", sig);
     signal(sig, SIGINT_handler);
     system("./caesar");
     exit(3);
}

/*void  SIGQUIT_handler(int sig)*/
/*{*/
/*     signal(sig, SIG_IGN);*/
/*     printf("From SIGQUIT: just got a %d (SIGQUIT ^\\) signal"*/
/*                          " and is about to quit\n", sig);*/
/*     shmdt(ShmPTR);*/
/*     shmctl(ShmID, IPC_RMID, NULL);*/
/*     system("./caesar");*/
/*     exit(3);*/
/*}*/

void SIGQUIT_handler(int signo, siginfo_t *info, union sigval extra)
{
	void *ptr_val = info->si_value.sival_ptr;
	int int_val = info->si_value;
	printf("From SIGQUIT: just got a %d (SIGQUIT ^\\) signal with value %d and is about to quit\n", signo, int_val);	
	shmdt(ShmPTR);
	shmctl(ShmID, IPC_RMID, NULL);
	exit(3);
}
