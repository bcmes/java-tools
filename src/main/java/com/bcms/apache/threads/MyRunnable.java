package com.bcms.apache.threads;

public class MyRunnable implements Runnable {
    int numero;
    char c;

    MyRunnable(int numero, char c) {
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
        MyRunnable r1 = new MyRunnable(1000, '-');
        MyRunnable r2 = new MyRunnable(1000, '>');

        Thread t1 = new Thread(r1); //a diferenca é que precisamos instanciar uma Thread para passar o runnable
        Thread t2 = new Thread(r2);

        //t1.start(); //registra a thread na fila de execucao do SO para execucao.
        //t2.start();

        r1.run();//Aqui vc nao esta executando em uma thread separada,
        r2.run();// vc esta executando na mesma thread como um metodo 'normal'.
    }
}
