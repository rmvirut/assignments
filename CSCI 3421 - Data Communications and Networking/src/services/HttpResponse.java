package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class HttpResponse {

    public String responseMessage;
    public ArrayList<String> responseHeaders;

    /**
     * Parses the buffered reader to create a new HttpResponse object
     *
     * @param r input stream containing response from server
     */
    public HttpResponse(BufferedReader r) throws IOException {
        responseHeaders = new ArrayList<String>();
        //parseBuffer(r);

        responseMessage = r.readLine();//read firstline and assing to message variable

        String text = "";
        while (text != null) {
            text = r.readLine();
            responseHeaders.add(text);
        }

        r.close();
    }

    //private void parseBuffer(BufferedReader r) throws IOException {
//        responseMessage = r.readLine();//read firstline and assing to message variable
//
//        String text = "";
//        while(text != "\r\n") {
//            text = r.readLine();
//            responseHeaders.add(text);
//        }
//    }
    @Override
    public String toString() {
        String text = String.format("%s\r\n", responseMessage);
        Iterator it = responseHeaders.iterator();

        while (it.hasNext()) {
            text += String.format("%s\r\n", it.next());
        }

        return text;
    }
}
