#include <stdio.h>
#include <string.h>
#include <fstream>
#include <iostream>

using namespace std;

/**
 * This is a program by Kojo Acquah to demonstrate a buffer overload attack on
 * an unsuspecting victim
 *
 * The code works by first overloading the buffer and then taking over the
 * instruction pointer of the code to execute a different function instead of
 * returning to main
 *
 **/

// char address[15];

void maliciousCode()
{
  printf("\n%s\n", "Muhahahahah! I'm in!");
  printf("\n%s\n", "Also, Hello World");

  //create a file in the directory
  std::ofstream ofile("virus.txt");
  ofile << "This could've totally been a virus or openin some other file" << std::endl;

  ofile.close();
}

void printer(const char *input)
{
  // printf("Combined %s\n", input);
  char buffer[10];
  strcpy(buffer, input);
  printf("Buffer says: %s\n", buffer);
}

int main(int argc, char **argv)
{
  printf("Address of maliciousCode: %p\n", maliciousCode);
  // sprintf(address, "%p", maliciousCode);
  printf("Address of maliciousCode: %x\n", maliciousCode);
  printf("%s\n", "Executed normally");
  // printf("%s\n", address);
  printer(argv[1]);
  return 0;
}
