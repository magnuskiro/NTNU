create server.c
create client.c

in server.c
	shared variable
	setmethod (int i) { sharedVariable += i; print sharedVariable }
	
in client.c
	make several threads
	each thread calls setmethod with a value

