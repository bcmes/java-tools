package com.bcms.apache.functional;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.logging.Logger;


/**
 * BiConsumer: variante da Consumer<T>, que recebe dois argumentos
 *
 * @FunctionalInterface
 * public interface BiConsumer<T, U> {
 *     void accept(T t, U u);
 *     // default methods removed
 * }
 */
public class MyBiConsumer {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //definition
        BiConsumer<Random, Integer> biConsumer =
                (random, number) -> LOG.info("value = " + random.nextInt() + number);

        //execution
        biConsumer.accept(new Random(10), 3);
    }
}
