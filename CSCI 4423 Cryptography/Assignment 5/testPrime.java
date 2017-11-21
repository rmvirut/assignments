/*
Stavros I. Konstantinidis
*/

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

public class testPrime
{
    static Scanner kbd = new Scanner(System.in);

    public static void main( String args[]) throws Exception
    {
        int k = 0, cnt = 0, tries = 1000;
        BigInteger X, Y = BigInteger.valueOf(tries), 
                   Two = BigInteger.valueOf(2), Total;
        String Num;

        System.out.print("\nWELCOME TO THE PRIMALITY TESTER\n");
        do {
            System.out.print("\nEnter a positive integer, or press <enter> to quit:\n> ");
            Num = kbd.nextLine();
            if (Num.length()==0) break;
            X = new BigInteger(Num);   
            if (X.equals(Two)) System.out.print("The number is prime.\n");
            // next, first test whether X is even > 2
            else if (!X.testBit(0)) System.out.print("The number is not prime.\n");
            else {
                if (X.isProbablePrime(5)) System.out.print("The number is probably prime.\n");
                else System.out.print("The number is not prime.\n");
            }
        } while (!X.equals(BigInteger.ZERO));

        pause();  
    }

    private static void pause() {
        System.out.print("\n...press enter...");
        kbd.nextLine();
        System.out.println("\n");
    }    
    
}

/*


*/
