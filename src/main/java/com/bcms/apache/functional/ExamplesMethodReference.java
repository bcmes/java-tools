package com.bcms.apache.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.logging.Logger;

public class ExamplesMethodReference {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //isso
        IntBinaryOperator max1 = (a, b) -> Integer.max(a, b);
        //é igual a isso
        IntBinaryOperator max2 = Integer::max;

        //e isso
        Function<String, Integer> toLength1 = s -> s.length();
        //e igual a isso
        Function<String, Integer> toLength2 = String::length;

        //e isso
        BiFunction<String, String, Integer> indexOf1 = (sentence, word) -> sentence.indexOf(word);
        //e igual a isso
        BiFunction<String, String, Integer> indexOf2 = String::indexOf;

        //e isso
        Consumer<String> printer1 = s -> System.out.println(s);
        //e igual a isso: um pouco diferente, pois a referencia para a instancia da classe, está em um atributo de classe
        Consumer<String> printer2 = System.out::println;

        //e isso
        Supplier<List<String>> newListOfStrings1 = () -> new ArrayList<>();
        //é igual a isso: essa é especial, pois é referencia a um construtor
        Supplier<List<String>> newListOfStrings2 = ArrayList::new;

        //o tipo do lambda (Supplier, etc..) vai determinar a forma de chamadar o lambda definido.
    }
}
