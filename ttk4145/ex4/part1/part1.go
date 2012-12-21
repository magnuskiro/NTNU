package main

import "fmt"

func main(){

    /*   A variable using the var keyword*/
    var newVar = 10;
    fmt.Println(newVar);
    
    /*    A variable using the := operator*/
    i:= 1;
    fmt.Println(i);
    i++;
    fmt.Println(i);
    
    /*    A constant*/
    const (
        v = "hei"; 
        n = 1337;
    )
    fmt.Println(v);
    fmt.Println(n);
    
    /*    A struct*/
    
    type car struct{
        color string;
        mark string;
    };
    var c = new(car); 
    c.mark = "merc";
    c.color= "black";
    fmt.Println("mark: ", c.mark);
    fmt.Println("color: ", c.color);
    
    /*    A for loop*/
    sum := 0
    for i := 0; i < len(a); i++ {
           sum += a[i]
    }
    fmt.Printf("This is the sum of the numbers in the array: %d\n", sum)

    
    /*    An array*/
    a := []int{0,1,2,3,4,5,6,7,8,9}
    fmt.Println("array: ", a)
           
    /*    a for x,y := range array loop*/
    for i,v := range a {
           fmt.Printf("a[%d]*2: %d\n", a[i], v*2)
    }
    
    /*  . What is x and y?
    i is the key, v is value, so i functions as the index in the array 
    and v is the array entry at that index    
    */
    
    /*  A while-like loop*/
    fmt.Println("while");
    i=0;
    for i<10 {
        fmt.Println(i);
        i++;
    }
    
    /*  A function.2*/
    fmt.Println(add(2,4));
}

    /*  A function.1*/
func add(x int, y int) int {
    return x + y
}


