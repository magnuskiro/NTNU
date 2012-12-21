/*
package main

import (
    "fmt"
    "time"
    )

func main(){
     
    for true {
        go p(5, "loopi");
        time.Sleep(1000000);
        fmt.Println("main");
    }


}

func p(i int64, msg string){
    for true{
        fmt.Println(i);
        go p(i+1, "loop");
    }
}

*/

/*29820 ish go routines.  */
package main 
import ( 
    "fmt" 
    "time" 
) 
func main() { 
  for i := 0; i < 100000; i++ { 
    go func(i int) { 
      fmt.Printf("Sleeping in %d\n", i) 
      time.Sleep(60*1e9)
    }(i) 
    <- time.After(10) 
  } 
}
