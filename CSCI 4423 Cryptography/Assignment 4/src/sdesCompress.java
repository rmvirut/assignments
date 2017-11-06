import java.util.Scanner;

public class sdesCompress
{
    public static void main( String args[]) throws Exception
    {
        Scanner kbd = new Scanner(System.in);
        char V = 'a';
        int i;       
        boolean ok_block;
        String block = "0101010101"; // some default block
        System.out.print("\n\n" + 
             "#####################################################################\n" +
             "  The user enters a 10-bit block B and a character V. \n" +
             "   (initial value of B = 0101010101 and of V = 'a')\n"+
             "  The program compresses B to the 8-bit value  sdes(B,V).\n" +
             "  The program TERMINATES if the block B is NOT of length 10.");
        while (true)
        {
            String inp;
            System.out.print("\n\n====================================================================\n");
            System.out.print("Enter a block B of 10 zeros/ones and a character V:\n" +
                             " (press enter to use the previous value of B or V)\n");
            System.out.print("B = ");  
            inp = kbd.nextLine();
            int n = inp.length();
            if (n>0 && n != 10) { System.out.print("--\nBye\n\n"); System.exit(0);}
            ok_block = true;
            for (i=0; i<n; i++) {
                if (inp.charAt(i) != '0'  && inp.charAt(i) != '1') {
                    System.out.print("Invalid block. Must enter 10 zeros/ones\n");
                    ok_block = false;  break;
                }
            }
            if (!ok_block) continue;
            else if (n>0) block = inp;

            System.out.print("V = ");
            String Vstr = kbd.nextLine();  
            if (Vstr.length() != 0) 
                V = Vstr.charAt(0);
            int m = compress(block, V);
            System.out.print("\nThe bits of sdes(B,V) are: "
                 + SDES.int2bitString(m,8));
        }
    }

    public static int compress (String B, int m)
    {
        int K = Integer.parseInt(B, 2);
        SDES S = new SDES(K);
        int em = S.encrypt(m);
        return (em^m);
    }

}


