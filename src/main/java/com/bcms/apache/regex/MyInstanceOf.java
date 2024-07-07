package com.bcms.apache.regex;

public class MyInstanceOf {

    public static void print(Object o) {
        //a partir do java 16, quarda a camada que deu match,
        // vc tera acesso somente aos atributos e metodos desta camada.
        //REMEMBER: o instanceof verifica se o "o" dado é do tipo CharSequence,
        // e a analise é feita olhando a hierarquia inteira do objeto real,
        // objeto real = objeto que foi instanciado, e não o tipo que o recepciona,
        //no caso aqui Object.
        if (o instanceof CharSequence cs) {
            System.out.println("This is a CharSequence of length " + cs.length());
        }
    }

    public void print2(Object o) {
        if (o instanceof String s && !s.isEmpty()) { //agora posso fazer esse tipo de coisa.
            int length = s.length();
            System.out.println("This object is a non-empty string of length " + length);
        } else {
            System.out.println("This object is not a string.");
        }
    }


    public static void main(String[] args) {
        //isso aqui
        Object name1 = new String("My name is Bruno.");
        //é igual a isso aqui: Devido a mão invisicel do compilador, LOL
        Object name2 = "My name is Bruno.";
        print(name2);
    }
}
