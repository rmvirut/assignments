/*
Stavros I. Konstantinidis
*/

import java.util.Scanner;

import javafx.util.converter.BigIntegerStringConverter;

import java.math.*;

public class FermatFactor
{
    static Scanner kbd = new Scanner(System.in);

    public static void main( String args[]) throws Exception
    {
        System.out.println();

        test_sqRoot();
        test_factor2();

        System.out.println();
    }


    public static BigInteger[] factor2(BigInteger N, int t) {
        // does at most t iterations to find and return two factors 
        // PQ[0] and PQ[1] of N, or returns -1 in PQ[0] and 1 in PQ[1]
        BigInteger[] PQ = new BigInteger[2];
        PQ[0] = BigInteger.valueOf(-1);
        PQ[1] = BigInteger.valueOf(1);
        BigInteger X, Y;
        for (long i=0; i<t; i++) {
            Y = BigInteger.valueOf(i*i);
            BigInteger A = N.add(Y);
            X = sqRoot(A);
            if (X.compareTo(BigInteger.ONE)>=0) {
                PQ[0] = X.subtract(BigInteger.valueOf(i)); 
                PQ[1] = X.add(BigInteger.valueOf(i));
                return PQ;
            }
        }
        return PQ;
    }    
 

    public static void test_factor2() {
        BigInteger N;
        BigInteger[] PQ = new BigInteger[2];
        int t;
        String sn;

        System.out.println("\nTesting factor2().................\n-");    

        sn = "1000";    t = 1000;
        N = new BigInteger(sn);
        PQ = factor2(N, t);
        System.out.println("N   = "+N+", t="+t+", P="+PQ[0]+", Q="+PQ[1]);
        System.out.println("P*Q = "+PQ[0].multiply(PQ[1]));

        sn = "239814337678271";    t = 1000;
        N = new BigInteger(sn);
        PQ = factor2(N, t);
        System.out.println("N   = "+N+", t="+t+", P="+PQ[0]+", Q="+PQ[1]);
        System.out.println("P*Q = "+PQ[0].multiply(PQ[1]));

        sn = "1016672674580621";    t = 1000;
        N = new BigInteger(sn);
        PQ = factor2(N, t);
        System.out.println("N   = "+N+", t="+t+", P="+PQ[0]+", Q="+PQ[1]);
        System.out.println("P*Q = "+PQ[0].multiply(PQ[1]));

        sn = "1016672674580621";    t = 100;   //number t of tries too small
        N = new BigInteger(sn);
        PQ = factor2(N, t);
        System.out.println("N   = "+N+", t="+t+", P="+PQ[0]+", Q="+PQ[1]);
        System.out.println("P*Q = "+PQ[0].multiply(PQ[1]));
    }


    public static BigInteger sqRoot(BigInteger N) {
        // returns the square root of N, if the root is an integer, or -1.
        BigInteger upperBound = new BigInteger(val);
        BigInteger lowerBound = new BigInteger();


        return new BigInteger.ZERO;
    }    
    

    public static boolean FTest(BigInteger X){
        //Theorem: 2^n-1 = 1 mod n
        BigInteger TWO = new BigInteger.valueOf(2);
        BigInteger ferm = TWO.pow(X.intValue()-1);

        return ferm.mod(X)== BigInteger.ONE;
    }

    public static void test_sqRoot() {
        String sn, sqrt;
        BigInteger N;

        System.out.println("\nTesting sqRoot().................\n-");    

        sn = "90000";   sqrt = "300";
        N = new BigInteger(sn);
        System.out.println("Computed square root of "+sn+": "+sqRoot(N));
        System.out.println("Actual   square root of "+sn+": "+sqrt);

        sn = "100";   sqrt = "10";
        N = new BigInteger(sn);
        System.out.println("Computed square root of "+sn+": "+sqRoot(N));
        System.out.println("Actual   square root of "+sn+": "+sqrt);

        sn = "10";   sqrt = "-1";  // square root of 10 is NOT an integer
        N = new BigInteger(sn);
        System.out.println("Computed square root of "+sn+": "+sqRoot(N));
        System.out.println("Actual   square root of "+sn+": "+sqrt);

        sn = "3086419753086419753024691358024691358025";
        sqrt = "55555555555555555555";
        N = new BigInteger(sn);
        System.out.println("Computed square root of "+sn+": "+sqRoot(N));
        System.out.println("Actual   square root of "+sn+": "+sqrt);
    }    

    
    public static void pause() {
        System.out.print("\n...press enter...");
        kbd.nextLine();
        System.out.println("\n");
    }    
    
}

/*

sample run:

*/
