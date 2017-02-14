#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void main(int argc, char *argv[])
{

    FILE* inFile;
    double searchArray[20]; //create searchArray
    for (int i = 0; i < 20; i++)
    {
        searchArray[i] = i + 1; //fill up the array
    }

    void introduction()
    { //introduction
        printf("This program reads number from a file called input.dat, reads the numbers.");
    } //end of introduction

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
        for (int i = 0; i < 20; i++)
        {
            printf("%f \n", store[i]);
        }
    } //end of display

    void readInput(double store[])
    {
        int i = 0;
        char fileName[100];

        //get fileName
        printf("Please input the filename: ");
        scanf("%s", fileName);

        //open the file
        inFile = fopen(fileName, "r");
        //just in case no file
        if(inFile == 0){
            printf("Error opening file");
            exit(1);
        }
        char line[100][21];//array of strings length 100

        //read content into searchArray
        while (!feof(inFile))
        {
            fgets(line[i], 20, inFile);
            sscanf(line[i], "%lf", &store[i]);

            i++;
        }
    }

    introduction();
    readInput(searchArray);
    sort(searchArray);
    printf("The sorted numbers are as follows: ");
    display(searchArray);
}
