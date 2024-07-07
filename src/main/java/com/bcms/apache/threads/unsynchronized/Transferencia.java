package com.bcms.apache.threads.unsynchronized;

public class Transferencia implements Runnable {
    private Banco banco;
    private int contaSaque;
    private int limiteTransferencia;
    public Transferencia(Banco banco, int contaSaque, int limiteTransferencia) {
        //Nao esquecer que este objeto pertencerá a thread que o instanciou.
        //Neste exemplo a main
        System.out.println("Transferencia na thread " + Thread.currentThread().getName());
        this.banco = banco;
        this.contaSaque = contaSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

    @Override
    public void run() {
        System.out.println("Transferencia.run() na thread " + Thread.currentThread().getName());
        //e esta parte do processamento ira para outra thread,
        //mas veja que se esta acessando objetos da thread main.
        while (!Thread.currentThread().isInterrupted()) {
            int contaDeposito = (int) (banco.getNumeroContas() * Math.random());
            int valor = (int) (this.limiteTransferencia * Math.random());
            this.banco.transferir(this.contaSaque, contaDeposito, valor);
        }
    }

}
