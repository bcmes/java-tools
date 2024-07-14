package com.bcms.apache.functional;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Consumer: aceita um argumento, processa e não devolve nada.
 *
 * @FunctionalInterface
 * public interface Consumer<T> {
 *     void accept(T t);
 *     // default methods removed
 * }
 */
public class MyConsumer {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //definition
        Consumer<String> consumer = (param) -> LOG.info("Length = " + param.length());
        //execution
        consumer.accept("Bruno");
    }
}
