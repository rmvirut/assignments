#include <stdio.h>

void main(int argc, char *argv[])
{
    double searchArray[20]; //create searchArray
    for (int i = 0; i < 20; i++)
    {
        searchArray[i] = i+1; //fill up the array
    }

    void introduction(){//introduction
        printf( "This program reads number from a file called input.dat, reads the numbers." );
    }//end of introduction

    void sort(double store[])
    {
        //function min
        int min(int start)
        {
            int i, tempMin = start;
            for (i = start + 1; i < 20; i++)
            {
                if (store[i] < store[tempMin])
                {
                    return i;
                }
                return tempMin;
            }
        }

        //procedure swap
        void swap(int l, int r)
        {
            int temp = l;
            l = r;
            r = temp;
        }

        //continue sort function
        for (int i = 0; i <= 19; i++)
        {
            swap(store[i], store[min(i)]);
        }

    } //end of sort

    void display(double store[])
    {
        for(int i =0; i<20){
            printf("%d", store[i])
        }
    }
}