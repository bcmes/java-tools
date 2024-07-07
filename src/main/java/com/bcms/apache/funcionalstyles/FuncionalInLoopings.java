package com.bcms.apache.funcionalstyles;

import java.util.stream.IntStream;

/**
 * Originalmente temos o paradigma Orientado a Objetos misturado com o
 * estilo imperativo de programação. Agora vamos mistura-lo com o estilo funcional.
 * No estilo Imperativo: dizemos o que fazer e também como fazer.
 *      - problema: muito detalhado.
 * No estilo Funcional: dizemos o que fazer e
 *  delegamos o "como", ou os detalhes, às bibliotecas subjacentes.
 */
public class FuncionalInLoopings {
    public static void main(String[] args) {
        //EXEMPLO 1: for simples
        //Imperativo
        for(int i = 0; i < 5; i++) {
            System.out.print(i);
        }
        //Funcional: se fosse i <= 5 bastaria usar .rangeClosed(0,5)..
        IntStream.range(0, 5).forEach(i -> System.out.print(i));
        //OU: aqui passo apenas a referencia ao metodo print, deixo que o forEach
        //dê os parametros a ele, e que tudo se resolva sozinho.
        IntStream.range(0, 5).forEach(System.out::print);

        //EXEMPLO 2: pulando steps do for
        //Imperativo
        for(int i = 0; i < 15; i = i + 3) {
            System.out.println(i);
        }
        //Funcional
        IntStream.iterate(0, i -> i < 15, i -> i + 3).forEach(System.out::print);
        //aqui o primeiro -> é como se fosse o ; e o segundo =

        //EXEMPLO 3: pulando steps do for com looping infinito e break
        //Imperativo
        for(int i = 0;; i = i + 3) {
            if(i > 20) break;
            System.out.print(i);
        }
        //Funcional
        IntStream.iterate(0, i -> i + 3).takeWhile(i -> i <= 20).forEach(System.out::print);


    }
}
