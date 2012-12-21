package main


import (
		"fmt"
		"time"
//		"rand"
	)

var ph = []string{"Mario", "Luigi", "Yoshi", "Bowser", "Peach"}
type fork int	
const bites = -1


func philosopher(name string, forkL, forkR chan fork, done chan bool) {
	fmt.Println(name, "is seated")
	counter := 0
	for i:=0;i>bites;i++ {
		fmt.Println(name,"is HUNGRY!!")
		<- forkL
		<- forkR
		fmt.Println(name,"is EATING!!")
		counter++
		time.Sleep(1*1e9) // with equal and constant sleep time, no deadlocks occured when taking 100 000 000 bites
//		time.Sleep(rand.Int63n(10)*1e3) // with random sleep time, no deadlocks occured when taking 100 000 000 bites
		forkL <- 1
		forkR <- 1
//		fmt.Println(name,"is thinking...")
		time.Sleep(1*1e9) // with equal and constant sleep time, no deadlocks occured when taking 100 000 000 bites
//		time.Sleep(rand.Int63n(10)*1e3) // with random sleep time, no deadlocks occured when taking 100 000 000 bites
		println(name, " has eaten n times. n = ", counter)
	}
	fmt.Println(name,"is satisfied and leaves table")
	done <- true
}

func main() {
	fork0 := make(chan fork, 1)
	fork0 <- 1
	forkL := fork0
	done := make(chan bool)
	for i:=1;i<len(ph);i++ {
		forkR := make(chan fork, 1)
		forkR <- 1
		go philosopher(ph[i], forkL, forkR, done)
		forkL = forkR
	}
/*	With one left handed philosopher, the left handed one, and the one to his immediate left, gets to eat less than the others
	because they will always try to get the same fork first; the fork between the two of them
*/		
	go philosopher(ph[0], fork0, forkL, done)
	time.Sleep(20*1e9)
//	for _ = range ph {
//		<- done
//	}
	fmt.Println("Table is empty")
}
	
