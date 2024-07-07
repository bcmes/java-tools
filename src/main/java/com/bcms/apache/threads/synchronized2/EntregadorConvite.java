package com.bcms.apache.threads.synchronized2;

public class EntregadorConvite implements Runnable {
    private ListaConvidades listaConvidados;
    public EntregadorConvite(ListaConvidades listaConvidados) {
        this.listaConvidados = listaConvidados;
    }
    @Override
    public void run() {
        //veja que outra thread acesso objeto ´listaConvidados' da thread main.
        String nomeThread = Thread.currentThread().getName();
        System.out.println(nomeThread + "iniciando atividades");
        boolean estaAberta = listaConvidados.isAberta();
        int quantidadePendente = listaConvidados.getQuantidadeEmailsPendentes();
        while (estaAberta || quantidadePendente > 0) {
            try {
                String email = listaConvidados.obterEmailConvidado(); //para aqui ate outra thread add email na lista
                if (email != null) {
                    System.out.println(nomeThread + " enviando email para " + email);
                    Thread.sleep((int) (Math.random() * 10000));
                    System.out.println("... envio de convite para " + email + " concluido");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            estaAberta = listaConvidados.isAberta();
            quantidadePendente = listaConvidados.getQuantidadeEmailsPendentes();
        }
        System.out.println(nomeThread + " encerrando atividades");
    }
}
