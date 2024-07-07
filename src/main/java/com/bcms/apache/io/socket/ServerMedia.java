package com.bcms.apache.io.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMedia {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
            Socket accept = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
            int n1 = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            float resultado = (n1+(float)n2)/2;

            DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
            dataOutputStream.writeFloat(resultado);
            dataOutputStream.flush();
            serverSocket.close();
        }
    }
}
