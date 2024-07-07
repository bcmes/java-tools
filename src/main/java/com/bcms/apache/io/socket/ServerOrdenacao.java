package com.bcms.apache.io.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerOrdenacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8082);
        while (true) {
            Socket accept = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
            String[] nomes = (String[]) objectInputStream.readObject();
            Arrays.sort(nomes);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(nomes);
            objectOutputStream.flush();
            serverSocket.close();
        }
    }
}
