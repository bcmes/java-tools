package com.bcms.apache.io.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientOrdenacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] nomes = {"Joaquim", "Maria", "Ana", "Bruno", "Leonardo"};
        Socket socket = new Socket("localhost", 8082);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(nomes);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        String[] nomesOrdenados = (String[]) objectInputStream.readObject();
        socket.close();
        for (int i = 0; i < nomesOrdenados.length; i++) {
            System.out.println(nomesOrdenados[i]);
        }
    }
}
