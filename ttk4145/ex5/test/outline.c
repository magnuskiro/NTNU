aa.c
// module globals
	barrier
	g_vote
	vote_barrier1 // used for synchronization
	vote_barrier2 // used for synchronization
init() {} // initiate atomic action before starting the other threads
enter() {
	pthread_barrier_wait();
}
vote() {
	vote_reset();
	wait();
	submit();
	wait();
}
####################
contr.c
enter_aa();
caculation -> g_var++;
	if(rand()%10) // fails every ten times
result = vote_aa();
if(false) {
	dosomething
}
###################
main.c

