package com.bcms.apache.threads.synchronized2;

import java.util.LinkedList;
import java.util.Queue;

public class ListaConvidades {
    private final Queue<String> emails = new LinkedList<String>();
    private boolean aberta = true;
    public int getQuantidadeEmailsPendentes() {
        synchronized (this.emails) { //objeto chave para sincronizacao
           return this.emails.size();
        }
    }
    public boolean isAberta() {
        return this.aberta;
    }
    //ao obter um email da fila, se a fila estiver vazia, poem a thread que fez o acesso em espera.
    //..a thread que acessar fica em espera, enquanto a lista for vazia.
    public String obterEmailConvidado() {
        String email = null;
        try {
            synchronized (this.emails) {
                while (this.emails.isEmpty()) {
                    if (!this.aberta) {
                        return null;
                    }
                    String nomeThreadAtual = Thread.currentThread().getName();
                    System.out.println("Lista vazia...");
                    System.out.println("colocando " + nomeThreadAtual + " em WAITING");
                    this.emails.wait();
                }
                email = this.emails.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email;
    }

    public void adicionar(String email) throws IllegalStateException {
        if (this.aberta) {
            synchronized (this.emails) {
                this.emails.add(email);
                System.out.println("Emails adicionados na lista...");
                System.out.println("notificando todas as threads de entrega");
                this.emails.notifyAll();
            }
        } else {
            throw new IllegalStateException("A lista ja esta fechada.");
        }
    }

    public void fecharLista() {
        System.out.println("Todos os convidados ja foram adicionados");
        System.out.println("Notificando todas as threads de entrega");
        this.aberta = false;
        synchronized (this.emails) {
            this.emails.notifyAll();
        }
    }
}
