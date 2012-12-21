SOURCES = $(wildcard *.c)
TARGETS = $(SOURCES:.c=)

# top-level rule, to compile everything.
all: $(TARGETS)

%:%.c
	gcc -lpthread -Wall -g -std=gnu99 -o $@ $< 

gets-hack: gets-hack.c
	gcc -fno-stack-protector -Wall -g -std=gnu99 -o $@ $< 
	

clean:
	rm -f $(TARGETS) 
        
rebuild: clean all

.PHONY: rebuild clean all

