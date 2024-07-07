package com.bcms.apache.threads.unsynchronized;

public class Banco {
    private Conta contas[];
    private static final int TRANSACOES_PARA_IMPRESSAO = 10000;
    public int contadorTransacoes = 0;
    public Banco(int numeroContas, int saldoInicial) {
        this.contas = new Conta[numeroContas];
        for (int i = 0; i < numeroContas; i++) {
            Conta c = new Conta(saldoInicial);
            contas[i] = c;
        }
    }

    //O problema desse metodo ser 'desincronizado´ para acesso de varias threads,
    //é que ele raramente terá seu bloco de código executado por inteiro, do inicio ao fim,
    //sendo constantemente tomado por outra thread para processamento, quando ainda estava
    //sendo processado pela thread atual.
    //..o algoritmo round-robin ajuda a entender melhor como é processado pelo SO as threads.
//    public void transferir(int contaSaque, int contaDeposito, int valor) {
//        if (contas[contaSaque].saldo < valor) return;
//        contas[contaSaque].saldo -= valor;
//        contas[contaDeposito].saldo += valor;
//        contadorTransacoes++;
//        if (contadorTransacoes % TRANSACOES_PARA_IMPRESSAO == 0) {
//            //para ver que o objeto que a thread acessa, pode nao, 'pertencer' a ela, ou reside nela.
//            System.out.print("Transferencia na thread "
//                    + Thread.currentThread().getName()
//                    + " saldo["+contas[contaSaque].saldo+"] < valor["+valor+"].: ");
//            imprimeTotal();
//        }
//    }

    //CORRECAO DO DESINCRONISMO, basta usar synchronized
    //garante que este metodo sera acessado por uma thread por vez, que
    //executara o bloco inteiro, e depois que terminar, liberara para outra thread.
    public synchronized void transferir(int contaSaque, int contaDeposito, int valor) {
        if (contas[contaSaque].saldo < valor) return;
        contas[contaSaque].saldo -= valor;
        contas[contaDeposito].saldo += valor;
        contadorTransacoes++;
        if (contadorTransacoes % TRANSACOES_PARA_IMPRESSAO == 0) {
            //para ver que o objeto que a thread acessa, pode nao, 'pertencer' a ela, ou reside nela.
            System.out.print("Transferencia na thread "
                    + Thread.currentThread().getName()
                    + " saldo["+contas[contaSaque].saldo+"] < valor["+valor+"].: ");
            imprimeTotal();
        }
    }


    private void imprimeTotal() {
        int total = 0;
        for (int i = 0; i < contas.length; i++)
            total += contas[i].saldo;
        System.out.println("Transacoes = " + contadorTransacoes + " total saldos = " + total);
    }

    public int getNumeroContas() {
        return this.contas.length;
    }
}
