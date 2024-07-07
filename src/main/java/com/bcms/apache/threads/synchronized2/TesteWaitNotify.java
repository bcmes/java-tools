package com.bcms.apache.threads.synchronized2;

import javax.swing.*;

public class TesteWaitNotify {
    public static void main(String[] args) {
        ListaConvidades lista = new ListaConvidades();

        Thread t1 = new Thread(new EntregadorConvite(lista), "entregador-1 ");
        Thread t2 = new Thread(new EntregadorConvite(lista), "entregador-2 ");
        t1.start();
        t2.start(); //essas duas threads ficam paradas esperando por add de emails.

        while (true) {
            String email = JOptionPane.showInputDialog(
                    "Digite o email do proximo convidado "
                    , ""
            );
            if (email != null) {
                lista.adicionar(email); //a thread main que destrava as duas threads congeladas acima..
            } else {
                lista.fecharLista();
                break;
            }
        }
    }
}
