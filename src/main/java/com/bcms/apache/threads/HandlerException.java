package com.bcms.apache.threads;

public class HandlerException {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Exceção na thread");
            }
        });

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exceção capturada na thread: " + t.getName());
                System.out.println("Mensagem da exceção: " + e.getMessage());
            }
        });

        thread.start();
    }
}

/**
 * .setUncaughtExceptionHandler é usado para definir um manipulador personalizado para exceções não capturadas em uma thread.
 * * é um tratador de exceções para exceções não capturadas em blocos try/catch na thread.
 * * evita que a thread termine abruptamente devido a uma exceção não tratada.
 */