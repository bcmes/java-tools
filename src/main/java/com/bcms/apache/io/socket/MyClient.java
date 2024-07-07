package com.bcms.apache.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        //cria um socket stream e o conecta no ip e porta especificados.
        Socket socket = new Socket("localhost", 8080);
        //socket.getInputStream() - retorna um canal de entrada de dados(byte a byte)
        //InputStreamReader - transforma um stream de bytes em stream de char
        //BufferedReader - transforma um stream de char em uma string
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println(bufferedReader.readLine());
        socket.close();
    }
}
