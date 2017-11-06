/*
Stavros I. Konstantinidis

works well in Java 8
*/

import java.util.Scanner;
import java.time.Clock;
import java.lang.Long;

public class genBin
{

    public static void main( String args[]) throws Exception
    {
        Scanner kbd = new Scanner(System.in);
        System.out.print("\nThe program reads the max number S of seconds to wait for, and\n"
               + "a word-length L up to 63, and generates binary strings of length\n"
               + "L until all possible L-bit strings are generated or S seconds\n"
               + "elapse. The program prints the last binary string generated.\n");
        System.out.print("\nEnter max number of seconds to wait for: ");
        long max;
        max = kbd.nextLong();
        System.out.print("\nEnter length of strings to generate: ");
        int len;
        len = kbd.nextInt();
        if (len == 0) System.exit(0);
        String S = generateBinStrings(len, max);
        System.out.print("\nLast binary string generated: \n" + S 
           + "\n-\nRepresents the number " + Integer.parseInt(S,2) + "\n");
    }

    public static String generateBinStrings(int len, long max)
    {
        if (len <= 0) return "";
        int i = 0;
        String S = "";
        boolean wait = true;
        long begt, endt=0;
        Clock clock = Clock.systemUTC();
        begt = clock.millis();
        while (wait) {
            S = int2bitString(i, len);
            // here add code (if any) to process S
            if (i == Long.MAX_VALUE) break;
            i++; 
            endt = clock.millis();
            wait = ((endt-begt)/1000.0) < max;
        }
        return S;
    }

// convert given int x to a string of n zeros/ones, 
// eg int2bitString(129,8): 10000001
    public static String int2bitString(int x, int n)
    {
        int mask = 1 << (n-1);
        String s = "";

        while( mask > 0) {
            s += ((x & mask) == 0) ? '0' : '1';
            mask >>= 1;
        }
        return s;
    }

}

