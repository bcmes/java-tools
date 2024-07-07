package com.bcms.apache.io.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        BufferedWriter bufferedWriter;
        while (true) {
            Socket accept = serverSocket.accept();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bufferedWriter.write("Eu come o java");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }
}
