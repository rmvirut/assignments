
import java.util.Scanner;

public class as2 {

    public static void main(String args[]) {
        String ptext;
        String key;
        Scanner in = new Scanner(System.in);
        System.out.print("\n\nENTER PLAIN TEXT and press <enter>:\n");
        ptext = in.nextLine();
        int N = ptext.length();
        System.out.print("\nENTER KEY TEXT (e.g., mykey) and press <enter>:\n");
        key = in.nextLine();
        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();

        System.out.print("\n\nENCRYPTED message shown in Hex and in Char format:\n->\n");
        int ctextint[] = new int[N];
        ctextint = runRC4(ptextc, keyc);
        display(ctextint);

        System.out.print("\n\n\nDECRYPTED message shown in Hex and in Char format:\n->\n");
        char ctextc[] = new char[N];
        for (int i = 0; i < N; i++) //1st convert the message ctextint to char array
        {
            ctextc[i] = (char) ctextint[i];
        }
        int ptxtint[] = new int[N];
        ptxtint = runRC4(ctextc, keyc);
        display(ptxtint);

        System.out.print("\n\n\n");
    }

    /**
     * The RC4 algorithm is applied on two given character arrays: the message
     * and the key. The corresponding output is returned as an array of integers
     * in [0-255].
     *
     * @param ptextc
     * @param keyc
     * @return
     */
    static int[] runRC4(char ptextc[], char keyc[]) {

        int[] ret = new int[ptextc.length];

        int[] s = new int[256];
        int[] k = new int[256];
        //construct array
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }
        //fill k with copies of keyc
        int count = 0;
        while (count < k.length) {
            for (int i = 0; i < keyc.length; i++) {
                if (count < k.length) {
                    k[count] = keyc[i];
                    count++;
                }
            }
        }

        int j = 0;
        //actual s array to be randomized
        for (int i = 0; i < s.length; i++) {
            j = (j + s[i] + k[i]) % k.length;
            //swap
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        //get first random number
        int i = j = 0;

        i = (i + 1) % k.length;
        j = (j + s[i]) % k.length;
        //swap
        int temp = s[i];
        s[i] = s[j];
        s[j] = s[i];
        //end swap

        int t = (s[i] + s[j]) % keyc.length;

        return s;
    }

    static void display(int data[]) //each data entry must be in [0-255]
    {
        for (int l = 0; l < data.length; l++) //1st print each data entry in hex format
        {
            String hex = String.format("%2X", data[l]);
            System.out.print(hex);
        }
        System.out.print("\n->\n");
        for (int l = 0; l < data.length; l++) //now print each data entry as a character
        {
            char curr = (char) data[l];
            System.out.print(curr);
        }
    }
}
