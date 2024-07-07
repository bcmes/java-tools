package com.bcms.apache.io;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) throws IOException {
        MyFileOutputStream();
        MyFileInputStream();

        System.out.println("-");

        MyDataOutputStream();
        MyDataInputStream();

        System.out.println("-");

        MyBufferOutputStream();

        System.out.println("-");

        MyBufferInputStream();
    }

    private static void MyFileOutputStream() throws IOException {
        byte[] dados = {19, 76, 75, -120, -44};
        FileOutputStream gravador = new FileOutputStream("dados.dat");
        for (int i = 0; i < dados.length; i++) {
            byte b = dados[i];
            gravador.write(b);
        }
        gravador.close();
        System.out.println("dados gravados com sucesso.");
    }

    private static void MyFileInputStream() throws IOException {
        FileInputStream leitor = new FileInputStream("dados.dat");
        int contador = 0;
        int ultimaLeitura = leitor.read();
        while (ultimaLeitura != -1) {
            byte b = (byte) ultimaLeitura;
            contador++;
            System.out.println("byte " + contador + ": " + b);
            ultimaLeitura = leitor.read();
        }
        leitor.close();
    }

    private static void MyDataOutputStream() throws IOException {
        byte b = 1;
        short s = 12;
        int i = 656;
        long l = 5566L;
        float f = 451.0F;
        double d = 1241.0;

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("tipos.dat"));
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.close();
    }

    private static void MyDataInputStream() throws IOException {

        DataInputStream dos = new DataInputStream(new FileInputStream("tipos.dat"));
        byte b = dos.readByte();
        short s = dos.readShort();
        int i = dos.readInt();
        long l = dos.readLong();
        float f = dos.readFloat();
        double d = dos.readDouble();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        dos.close();
    }


    /*EXEMPLO BUFFER OUT*/

    private static void MyBufferOutputStream() throws IOException {
        /**
         * tipo - para determinar o tipo: 0 short, 1 float, 2 String
         * tamanho - para determinar a quantidade de elementos
         * dados - bytes que devem ser interpretados de acordo com o tipo e tamanho
         * .... esses tres blocos acima se repetem continuamente no file ....
         */
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("teste.dat")));
        String texto = "Today is a good day.";
        float[] floats = {1312.123F, 12.344F, -914.5323F};
        short[] shots = {1015, 2316, -1788, 4118};
        gravarArrayString(texto, dos);
        gravarArrayFloat(floats, dos);
        gravarArrayShort(shots, dos);
        fecharArquivo(dos);


    }

    public static void fecharArquivo(DataOutputStream dos) throws IOException {
        dos.flush();
        dos.close();
    }

    public static void gravarArrayShort(short[] array, DataOutputStream dos) throws IOException {
        dos.write((byte)0);
        dos.writeInt(array.length);
        for (int i = 0; i < array.length; i++) {
            dos.writeShort(array[i]);
        }
    }

    public static void gravarArrayFloat(float[] array, DataOutputStream dos) throws IOException {
        dos.write((byte)1);
        dos.writeInt(array.length);
        for (int i = 0; i < array.length; i++) {
            dos.writeFloat(array[i]);
        }
    }

    public static void gravarArrayString(String texto, DataOutputStream dos) throws IOException {
        dos.write((byte)2);
        //o formato utf contem o tamanho da string
        dos.writeUTF(texto);
    }

    /*EXEMPLO BUFFER OUT*/


    /*EXEMPLO BUFFER IN*/
    private static void MyBufferInputStream() throws IOException {
        /**
         * tipo - para determinar o tipo: 0 short, 1 float, 2 String
         * tamanho - para determinar a quantidade de elementos
         * dados - bytes que devem ser interpretados de acordo com o tipo e tamanho
         * .... esses tres blocos acima se repetem continuamente no file ....
         */
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("teste.dat")));
        int first8Bits = 0;
        int tamanhoArray = 0;
        while ((first8Bits = dis.read()) != -1) { //ler um byte do file
            byte oneByte = (byte) first8Bits;
            switch (oneByte) {
                case 0: //short
                    tamanhoArray = dis.readInt();
                    short[] arrayShort = new short[tamanhoArray];
                    for (int i = 0; i < arrayShort.length; i++) {
                        arrayShort[i] = dis.readShort();
                    }
                    printShorts(arrayShort);
                    break;
                case 1: //float
                    tamanhoArray = dis.readInt();
                    float[] arrayFloat = new float[tamanhoArray];
                    for (int i = 0; i < arrayFloat.length; i++) {
                        arrayFloat[i] = dis.readFloat();
                    }
                    printFloats(arrayFloat);
                    break;
                case 2: //string
                    //o formato utf contem o tamanho da string
                    String texto = dis.readUTF();
                    printStrings(texto);
                    break;
            }
        }
    }

    private static void printStrings(String texto) {
        System.out.println("string: " + texto);
    }

    private static void printFloats(float[] arrayFloat) {
        System.out.print("array de floats: ");
        for (int i = 0; i < arrayFloat.length; i++) {
            System.out.print(arrayFloat[i] + " ");
        }
        System.out.println();
    }

    private static void printShorts(short[] arrayShort) {
        System.out.print("array de short: ");
        for (int i = 0; i < arrayShort.length; i++) {
            System.out.print(arrayShort[i] + " ");
        }
        System.out.println();
    }
    /*EXEMPLO BUFFER IN*/
}
