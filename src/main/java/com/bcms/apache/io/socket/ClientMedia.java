package com.bcms.apache.io.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientMedia {
    public static void main(String[] args) throws IOException {
        int x = 104, y = 335;
        Socket socket = new Socket("localhost", 8081);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeInt(x);
        dataOutputStream.writeInt(y);
        dataOutputStream.flush();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        float resultado = dataInputStream.readFloat();
        socket.close();
        System.out.println("Media entre " + x + " e " + y + " = " + resultado);
    }
}
