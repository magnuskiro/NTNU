#include <stdio.h>
#include <string.h>

void print_me()
{
    printf("This function is never called!\n");
}

int func()
{
    char buffer[16] = {0};

    gets(buffer);
    printf("The user inputted a line of %d characters\n", strlen(buffer));

    return 0;
}


int main()
{
    func();

    return 0;
}
