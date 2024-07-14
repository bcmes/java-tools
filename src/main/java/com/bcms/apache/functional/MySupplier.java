package com.bcms.apache.functional;

import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *  Supplier : não aceita nenhum argumento e retorna um objeto
 *
 * @FunctionalInterface
 * public interface Supplier<T> {
 *     T get();
 * }
 */
public class MySupplier {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //definition
        Supplier<String> supplier = () -> "my supplier";
        //execution
        String result = supplier.get();
        //output
        LOG.info(result);
    }
}
