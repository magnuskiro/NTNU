# Compiler flags go here.
CFLAGS = -std=c99 -g -Wall -I . -MMD

# Linker flags go here.
LDFLAGS = -g -lpthread -lcomedi -lm

# list of sources
SOURCES = $(shell find -name "*.c")

# Program executable file name.
TARGET = elevtest

# Default rule, to compile everything.
all: $(TARGET)


# -- The below lines should not need to be changed --

# Define dependencies
DEPS = $(shell find -name "*.d")

# Define all object files.
OBJECTS = $(SOURCES:.c=.o)

# rule to link the program
$(TARGET): $(OBJECTS)
	gcc $(LDFLAGS) -o $@ $^

# Compile: create object files from C source files.
%.o : %.c
	gcc $(CFLAGS) -c -o $@ $< 

# Include dependencies, if any.
-include $(DEPS)

# rule for cleaning re-compilable files.
clean:
	rm -f $(TARGET) $(OBJECTS) $(DEPS)

rebuild: clean all

.PHONY: all rebuild clean

