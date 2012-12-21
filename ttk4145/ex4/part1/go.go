package main

import (
    "fmt"
    "time"
    "runtime"
    )

func main(){

    go p(15,"going");
    for true{
        p(5, "looped");
    }

}

func p(i int64, msg string){
    for true{
        runtime.Gosched();
        time.Sleep(i);
        fmt.Println(msg);
    }
}
