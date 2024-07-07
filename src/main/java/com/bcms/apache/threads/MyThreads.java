package com.bcms.apache.threads;

public class MyThreads  extends Thread {
    int numero;
    char c;

    MyThreads(int numero, char c) {
        this.numero = numero;
        this.c = c;
        System.out.printf("Thread [%s] vai imprimir %d vezes o caractere %c %n", Thread.currentThread().getName(), numero, c);
    }

    @Override
    public void run() { //este bloco sera executado em uma thread separada, da tread deste obj.
        System.out.printf("[%s]", Thread.currentThread().getName());
        for (int i = 0; i < this.numero; i++) { //o processamento do looping simplesmente para, e depois volta, quando é sua vez de processar novamente.
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        MyThreads t1 = new MyThreads(1000, '-');
        MyThreads t2 = new MyThreads(1000, '>');
        t1.start(); //registra a thread na fila de execucao do SO para execucao.
        t2.start();
    }
}
