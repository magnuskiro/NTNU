package main

var i int;

func set(c chan int) {
    no := <- c
    if no != i {
        i = no;
        c <- i;
    }
}

func get(c chan int){
    c <- i;
}

func main(){
	c := make(chan int)
	go set(c);
    go get(c);
}
