#include <stdio.h>
#include "linearSearch.h"

void introduction()
{ //introduction
	printf("This program reads number from a file called input.dat, reads the numbers.");
} //end of introduction

void readInput(double *store)
{
	int i = 0;
	char fileName[100];

	//get fileName from user
	printf("Please input the filename: ");
	scanf("%s", fileName);

	//open the file
	FILE *inFile = fopen(fileName, "r");

	//check for possible errors like no file or failure to open
	if (inFile == 0) {
		printf("Error opening file");
		exit(1);
	}

	//read content into searchArray
	while (!feof(inFile) || i < 19)
	{
		fscanf(inFile, "%lf", (store + 1));
		i++;
	}
}//end of readInput

 //function min
int minimum(int start, double *store) {
	int i;
	int tempMin = start;
	for (i = start + 1; i < 20; i++)
	{
		if ((store + i) < (store + tempMin))
		{
			return i;
		}
		return tempMin;
	}
}//end of min

//procedure swap
void swap(double *l, double *r) {
	double *temp = l;
	l = r;
	r = temp;
}//end of swap

void sort(double *store)
{

	//continue sort function
	for (int i = 0; i <= 19; i++)
	{
		swap((store + i), (store + minimum(i, store)));
	}

} //end of sort

void display(double *store)
{
	for (int i = 0; i < 20; i++)
	{
		printf("%lf \n", (store + i));
	}
} //end of display



int main()
{
	//print the program's introduction
	introduction();
	//read the input from the file
	double searchArray[20];
	double *arrayPointer = searchArray;
	readInput(arrayPointer);
	sort(arrayPointer);
	printf("The sorted numbers are as follows: ");
	display(arrayPointer);

	return 0;
}
