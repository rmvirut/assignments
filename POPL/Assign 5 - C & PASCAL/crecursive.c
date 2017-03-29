#include <stdio.h>

int factorial(int num){
        if(num == 0){
            return 1;
        }
        return (num * factorial(num -1));
}

void main(int argc, char *argv[]) {
    //declare variables
    int number;

    //introduce to the user and prompt for number
    printf("Hello, I'm factorial \nEnter a number to continue...");
    scanf("%d", &number);

    printf("%d \n", factorial(number));

}