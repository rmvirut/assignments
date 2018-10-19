package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        PrintWriter pw;
        Socket s = new Socket();
        InetSocketAddress host;
        String hostname;
        int port;


        intro();
        print("Enter the IP or hostname of the server you're connecting to: ");
        hostname = kbd.nextLine();
        print("Enter the port number (use 80 as default): ");
        port = kbd.nextInt();

        try {
            host = new InetSocketAddress(hostname, port);
            s.setKeepAlive(true);
            s.connect(host);

            print(s.isConnected() ? "\nSuccessfully connected to host" : "\nFailed to connect");
            pw = new PrintWriter(s.getOutputStream());
            print("\nSending request");

//            create http request
            HttpRequest request = new HttpRequest("GET", "/");
            request.addHeader("Connection", "Keep-Alive");

            pw.print(request.getRequestLine());
            pw.print("Host: " + hostname + "\r\n");
            pw.println();
            pw.flush();


//          create HttpResponse object

            HttpResponse response = new HttpResponse( new BufferedReader(new InputStreamReader(s.getInputStream())));
            print("\n");
            print(response.toString());

        } catch (IOException e) {
            print(e.getMessage());
        }


    }

    /**
     * @param hostnameOrIP
     */
    public static void validateServer(String hostnameOrIP) {

    }

    /**
     * Method to print text. System.out.print[ln] is to long
     *
     * @param text
     */
    public static void print(String text) {
        System.out.print(text);
    }

    /**
     * Print the program's introductio to the user and instructions to follow
     *
     */
    public static void intro() {
        print("\nThis is a primitive browser. Provide it with the information it requests and " +
                "\nit'll take you to the server page(s) you'd like to see.\n");
    }

    /**
     *
     * @param text
     */
    public static void findOS(String text){
        String serverLine = "server: .*";

    }

}
