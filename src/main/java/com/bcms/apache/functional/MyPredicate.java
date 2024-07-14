package com.bcms.apache.functional;

import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * Predicate: é usado para testar um objeto. Tem entrada e saída.
 *
 * @FunctionalInterface
 * public interface Predicate<T> {
 *     boolean test(T t);
 *     // default and static methods removed
 * }
 */
public class MyPredicate {

    private static final Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        //definition
        Predicate<String> predicate = p -> p.length() == 5;
        //execution
        boolean result = predicate.test("Bruno");
        //output
        LOG.info(Boolean.toString(result));
    }
}
