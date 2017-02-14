#include <stdio.h>
/*Pascal does not require explicit import of I/O library or main statement*/
void main(int argc, char *argv[]){
    int i, n = 0;/*variable declaration shorter and simpler in C*/
    printf("Enter an integer: ");
    scanf("%d", &n);/*Reading input shorter in Pascal*/
    for (i = n; i>=1; i--){printf("%d \n", (i*i*i));}/*Printing shorter in Pascal*/
    printf("Well that was easy");
}