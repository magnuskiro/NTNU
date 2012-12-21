#include <stdio.h>
#include <unistd.h>

#define PRODUCT(x,y) x*y
int main() {
    printf("ASSIGNMENT 1: STRANGE PRICE LIST\n");
    /* List prices of stuff */
    int price_banana = 5;
    int price_orange = 7;
    int price_coke   = 12;
    int price_book   = 200;
    int price_stereo = 4999;

    /* Print prices of stuff */
    printf("The price of banana is %d\n", price_banana );
    printf("The price of orange is %d\n", price_orange );
    printf("The price of coke   is %d\n", price_coke   );
    printf("The price of book   is %d\n", price_book   );
    printf("The price of stereo is %d\n", price_stereo );
    printf("\n");




    printf("ASSIGNMENT 2: BASIC ARITHMETICS, PART ONE\n");

    int sum;                    

    sum = 4;                    /* Take 4                       */

    sum = sum + 2;              /* Then add 2.                */

    printf("The sum of 4 and 2 is %d\n", sum);    /* The result is...? */
    printf("\n");





    printf("ASSIGNMENT 3: BASIC ARITHMETICS, PART TWO\n");

    printf("The product of 1+1 and 2+2 is %d\n", PRODUCT((1+1),(2+2)));
    printf("\n");


    printf("ASSIGNMENT 4: EQUALITY TESTING IS SIMPLE\n");

    int i = 5;
    int j = 2;

    printf("i = %d;\n", i);
    printf("j = %d;\n", j);

    if (i == j)
        printf("i and j are the same\n");
    
    printf("\n");

    printf("ASSIGNMENT 5: SO IS INEQUALITY TESTING\n");

    int k = 0;
    int l = 0;

    printf("k = %d;\n", k);
    printf("l = %d;\n", l);

    if (k != l)
        printf("k and l are not the same\n");

    printf("\n");


    printf("ASSIGNMENT 6: RANGE TESTING\n");

    printf("Is 25 between 2 and 10?\n");
    if (2 < 25 > 10)
        printf("yes!\n");
    else
        printf("no!\n");

    printf("\n");


    printf("ASSIGNMENT 7: THE OLD SWITCHAROO\n");

    printf("What is the original?\n");
    int var = 1;
    int switch_with = 321;
    switch(var) {

        /* Is it zero? */
        case 0: 
            printf("The original is zero!\n");
            var = switch_with;
            break;

        case 1: 
            printf("The original is one!\n");
            var = switch_with;
            break;
            
        default:
            printf("The original is something else!\n");
            var = switch_with;
            break;
    }

    printf("What did we switch it with?\n");
    printf("We switched it with %d!\n", var);
    printf("\n");


    printf("ASSIGNMENT 8: ARITHMETIC USING A FUNCTION\n");

    printf("When you add 10 and 20 you get %d\n", add_using_a_function(10, 20));
    printf("\n");


    printf("ASSIGNMENT 9: LISTS OF STRINGS\n");

    char *array_of_strings[6] = {"monkey", "banana", "take", "angry", "trouble", "\n"};
	
    printf("The strings are: ");
	for (i=0;i<6;i++) 
	{
		printf("%s ", array_of_strings[i]);
	}
    printf("\n");


    printf("ASSIGNMENT 10: COUNT TO INFINITY!\n");

    int c;
    for (c = 0; c<10; c++) {
        printf("%d", c);
        //sleep(1);
    }
    

    printf("\nMORALE: gcc will let you get away with anything as long as you don't compile with -Wall.\n");

    return 0;
}


/* Using this function, we can add two numbers! */
int add_using_a_function(int x, int y)
{
   return x+y; 
}



