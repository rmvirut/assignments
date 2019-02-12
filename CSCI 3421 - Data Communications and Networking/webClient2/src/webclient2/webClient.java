package webclient2;

import java.util.*;
import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class webClient {

    private static int port = 80; //set default port number

    public static void main(String[] args) {

        intro();

        try {

            //get hostname and port number[ if any]
            Scanner kbd = new Scanner(System.in);
            print("\nPlease enter the URL or IP address of the host: ");
            String hostname = kbd.nextLine();
            if (gotAPort(kbd)) {
                print("Enter the port number here: ");
                port = kbd.nextInt();
            }
            
            // create new url object
            URL url;
            //append https (new web standard) to skip redirecting from http to https
            url = new URL("https://" + hostname);
            //open connection to the host (handshake)
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            //configure http request parameters and headers
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            HttpsURLConnection.setFollowRedirects(true);//follow redirects if resources is moved

            //connect to the host
            connection.connect();
            print("Connected to the host successfully");

            //determine and print the server's OS info
            String serverOS;
            serverOS = connection.getHeaderField("Server") == null ? "is kept "
                    + "private" : connection.getHeaderField("Server");
            print(serverOS.equalsIgnoreCase("is kept private") ? 
                    "\nThe server OS is kept private\n"
                    : "\nThe server is running on " + serverOS + "\n");
            
            print("\nPress 'Enter' key to continue...\n");
            kbd.nextLine();//pause
            
            //print the content of the default page
            printContent(new InputStreamReader(connection.getInputStream()));

            //close the connection and streams
            kbd.close();
            connection.disconnect();
            System.exit(0);
        } catch (UnknownHostException e) {
            print(e.getMessage() + "\nThe hostname is likely invalid\n");
        } catch (IOException e) {
            print(e.getMessage());
        } catch (Exception e) {//handle any other unspecified errors
            print(e.getMessage());
        }
    }

    /**
     * Method to print text because System.out.print/ln is to long
     *
     * @param text the text to be printed to the screen/output
     */
    public static void print(String text) {
        System.out.print(text);
    }

    /**
     * Method will confirm if the user would like to use default port or provide
     * one. Will only accepts 'y' or 'n' as a valid response. Any other response
     * will be considered as 'n'
     *
     * @param kbd System input stream to read typed response
     * @return false if n, true if y
     */
    public static boolean gotAPort(Scanner kbd) {
        print("Will you be providing a port number?(y/n)");
        String response = kbd.nextLine();
        return response.equalsIgnoreCase("y");
    }

    /**
     * Print the program's introduction to the user and instructions to follow
     *
     */
    public static void intro() {
        print("\nThis is a primitive browser. Provide it with the information it requests and "
                + "\nit'll take you to the server page(s) you'd like to see.\n");
    }
    
    /**
     * Receives the input as an input stream reader and outputs its content
     * to a screen
     * 
     * @param in InputStreamReader object containing text
     * @throws IOException 
     */
    public static void printContent(InputStreamReader in) throws IOException {
        BufferedReader br = new BufferedReader(in);
        String strTemp = "";
        while (null != (strTemp = br.readLine())) {
            System.out.println(strTemp);
        }
    }
}
