#! /bin/bash
rm atomicaction
clear
gcc -std=c99 -lpthread -o atomicaction atomicaction.c controller.c -I.
./atomicaction
