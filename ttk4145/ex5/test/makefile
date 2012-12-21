CFLAGS = -pedantic -g -Wall -lpthread -std=c99

CC = gcc
LIBS = -lm 
INCLUDES =
OBJS = test.o
SRCS = test.c
HDRS = 

all: test

test: test.o ${OBJS}
	${CC} ${CFLAGS} -o test.out ${OBJS} ${LIBS}

depend: 
	makedepend ${SRCS}

clean:
	rm *.out

print:
	more Makefile $(HDRS) $(SRCS) | enscript -2r -p listing.ps

# DO NOT DELETE
