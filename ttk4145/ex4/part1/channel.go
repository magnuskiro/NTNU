package main

import (
	"fmt"
	"runtime"
	"time"
)

var t int

// reads an int from the channel and multiplies it with 2
func calcSum(c chan int) {
	no := <- c
	//runtime.Gosched()
	if no == 1 {
		fmt.Println(no, "bottle of beer on the wall!",no,"bottle of beer!")
		t = 99
		fmt.Println("Go to the store, buy some more!",t,"bottles of beer on the wall!\n")
	} else {
		runtime.Gosched()
		fmt.Println(no, "bottles of beer on the wall!",no,"bottles of beer!\nTake one down, pass it around",no-1,"bottles of beer on the wall!\n")
	}
}

// increments a counter which it puts on the channel
func count(c chan int) {
	//runtime.Gosched()
	c <- t
	t--
}

func main() {
	t = 99
	c := make(chan int)
	for i := 0; i < 99; i++ {
		go count(c)
		go calcSum(c)
		time.Sleep(1*1e7)
	}
}
	
	
