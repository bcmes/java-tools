package com.bcms.apache.threads.unsynchronized;

public class AcessoDesincronizadoAoObjeto {
    public static void main(String[] args) {
        int saldoInicial = 1000;
        int quantidadeContas = 10;
        //cria as n contas com o mesmo saldo
        Banco banco = new Banco(quantidadeContas, saldoInicial);

        //vai criar uma thread para cada conta
        //as instancias de "new Transferencia", pertecem a thread a qual o comando
        //new foi executado, neste caso a main
        //Observe que por mais que se esteja dando a referencia para 'Thread', o obj
        //foi gerado na Thread main.
        for (int indexContaSaque = 0; indexContaSaque < quantidadeContas; indexContaSaque++) {
            Thread t = new Thread(new Transferencia(banco, indexContaSaque, saldoInicial));
            t.start();
        }
    }
}

/**
 * Este codigo é para representa o problema da falta de sincronismo,
 * quando varias threads acessam os mesmos objetos de forma a concorrer
 * de forma desincronizada umas com as outras, assim uma thread atropela o
 * processamento da outra. Assim cada thread toma o processamento, pelo meio, dos objetos
 * da outra thread.
 */