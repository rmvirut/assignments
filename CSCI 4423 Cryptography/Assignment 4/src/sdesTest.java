/*
Stavros I. Konstantinidis
*/

import java.util.Scanner;

public class sdesTest
{
  public static void main( String args[]) throws Exception
  {
    Scanner kbd = new Scanner(System.in);
    System.out.print("\n\n#######################################################################\n"
         + "  The user enters a key and a message, which is encrypted with sdes. \n" 
         + "  The program TERMINATES when the key is of length NOT equal to 0 or 10");

    String key = "0101010101"; // some default key

    while (true)
    {
        String inp, M;
        System.out.print("\n\n====================================================================\n"
                    + "Enter a key of 10 zeros/ones, or press enter to use the previous key\n");
        inp = kbd.nextLine();
        int n = inp.length();
        if (n==10) key = inp;
        else if (n>0) break;
        int K = Integer.parseInt(key, 2);
        SDES A = new SDES(K);
        System.out.print("Enter a text message to encrypt with sdes using key "+key+"\n");
        M = kbd.nextLine();
        n = M.length(); 
        System.out.print("--\nThe ASCII codes of the characters in the encrypted message are:\n--");
        
        int[] C = new int[n];

        for (int i=0; i<n; i++) {
           C[i] = (int)M.charAt(i);
           C[i] = A.encrypt(C[i]);    // integer returned could be negative, then add 256
           if (C[i]<0) C[i] = 256+C[i];
           String hex = String.format("%02X", C[i]);
           if (i%10==0) System.out.println();
           System.out.print(hex+" ");  
        }

        System.out.print("\n\n--\nThe original plaintext message is: \n");         
        int m;  
        for (int i=0; i<n; i++) {
           m = A.decrypt(C[i]);    // integer returned could be negative, then add 256
           if (m<0) m = 256+m;
           char c = (char)m;
           System.out.print(c);  
        }
    }
    System.out.println();
  }

  public static  boolean isValidPhrase(String s)
  // tells whether all characters in s are capital letters or spaces
  {
    boolean itsok = true;
    for (int i=0; i<s.length(); i++) {
      int m = (int)s.charAt(i);
      if (m!=32 && !(m>64 && m<91))
      {itsok=false; break;}
    }
    return itsok;
  }

}

/*

sample run:

====================================================================
Enter a key of 10 zeros/ones, or press enter to use the previous key

Enter a message to encrypt with sdes
> hello
--
The ASCII codes of the characters in the encrypted message are:
--
01 5F A4 A4 BA 

*/
