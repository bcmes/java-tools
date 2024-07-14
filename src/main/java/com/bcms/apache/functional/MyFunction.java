package com.bcms.apache.functional;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * Function: pega um objeto do tipo T e faz transformação desse objeto para outro tipo U.
 *  Predicate pode fazer a mesma coisa.
 *
 * @FunctionalInterface
 * public interface Function<T, R> {
 *     R apply(U u);
 *     // default and static methods removed
 * }
 */
public class MyFunction {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //definition
        Function<String, Integer> function = s -> s.length();
        //execution
        Integer output = function.apply("Bruno");
        //output
        LOG.info(output.toString());
    }
}
