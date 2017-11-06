import java.util.Scanner;

public class sdesMDHash
{

    public static void main( String args[]) throws Exception
    {
        Scanner kbd = new Scanner(System.in);
        int ch;

        System.out.print("\nThe program TERMINATES when the given message is empty.\n");

        while (true)
        {
            String M;
            System.out.print("\n\n====================================\n");
            System.out.print("Enter a message,  M = ");
            M = kbd.nextLine();    
            if (M.length()==0) System.exit(0);
            ch = Hash(M);
            System.out.print("\nThe 8 bits of the Hash value are: ");
            System.out.print("\n"+SDES.int2bitString(ch, 8));  
        }
    }


    public static  int compress(String B,  int V)  
         // Implements  h(B||V) = SDES(B,V) xor V,  where B is the block part
    {    //B is used by SDES as the key, implemented as a String of '0','1'
        int K = Integer.parseInt(B, 2);
        SDES S = new SDES(K);
    	int eV = S.encrypt(V);
    	return (eV ^ V);
    }


    public static String pad(String M) 
    	//message M will be padded to get message Y of length a multiple of 10
    	//The message Y will be a string of '0','1' representing the bit-string
            // consisting of the bits in M plus the padded ones.
    {
    	int x, n = M.length(), // 8n = message length in bits
    		 r = (8*n)%10,   
    	// bit-message to be padded to get new message of bit-length a multiple of 10
    	     d = 10-r-1,   //implies that d+r+1 equals 10, so final 
    			               //length = 8n+1+d+10 = multiple of 10
             y = 8*n+(1+d+10);
    	String Y = SDES.int2bitString((int)(M.charAt(0)), 8);    
    	for (int i=1; i<n; i++) 
    	   {Y = Y + SDES.int2bitString((int)(M.charAt(i)), 8);}
    	Y = Y + '1';
    	for (int i=0; i<d; i++)  
    	 {Y = Y + '0';} 
    	Y = Y + SDES.int2bitString(8*n+1+d+10, 10);
    	return Y;
    }


    public static int Hash(String M)
    {
    	String Y = pad(M);  //Y is a string of '0' and '1'; 
    	int i, n = Y.length(), m = (n/10); //m = number of 10-bit blocks in Y    	                      
    	int V = 0xF0;  // use V = F0h = last 8 bits of IV in SHF1
    	for (i=0; i<m; i++) {
            int t = 10*i;
    	    String B = Y.substring(t, t+10); 
    	    V = compress(B, V); 
    	}
    	return V;
    }

}


