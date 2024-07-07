package com.bcms.apache.io;

import java.io.*;

public class FileIOStream2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite e sera armazenado no arquivo novoTeste.tmp");
        String entrada = bf.readLine();

        BufferedWriter out = new BufferedWriter(new FileWriter("novoTeste.tmp"));
        out.write(entrada);
        out.flush();
        out.close();
        System.out.println("armazenado.");
    }
}
