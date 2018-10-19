package services;

import java.util.ArrayList;

public class HttpRequest {
    private String requestLine;
    private ArrayList<String> headers;

    /**
     * Creates a new HTTP request object. Default protocol version is HTTP/1.1
     *
     * @param method one of  GET, POST, HEAD, PUT, or DELETE
     * @param object directory of the document we're looking for on the server
     */
    public HttpRequest(String method, String object) {
        requestLine = String.format("%s %s HTTP/1.1\r\n", method, object);
        headers = new ArrayList<String>();
    }

    public void addHeader(String headerTitle, String value) {
        headers.add(String.format("%s: %s\r\n", headerTitle, value));
    }

    public String getRequestLine() {
        return requestLine;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }
}
