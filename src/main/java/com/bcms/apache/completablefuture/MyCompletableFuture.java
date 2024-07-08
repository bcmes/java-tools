package com.bcms.apache.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MyCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        System.out.println("\nCompletable Future:");
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        System.out.println(completableFuture.getNow("Value if absent !"));
//        completableFuture.complete("Finished.");
//        System.out.println(">> " + completableFuture.get());



//        System.out.println("Main Thread: " + Thread.currentThread().getName());
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Future Thread: " + Thread.currentThread().getName());
//        });
//        completableFuture.get();




//        System.out.println("Main Thread: " + Thread.currentThread().getName());
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Future Thread: " + Thread.currentThread().getName();
//        });
//        System.out.println(completableFuture.get());




//        CompletableFuture<String> completableFuture = CompletableFuture
//                .supplyAsync(()->"Like and ")
//                .thenApply(supplyResult -> supplyResult + "Subscribe ")
//                .thenApply(thenApplyResult -> thenApplyResult + "my channel.");
//        System.out.println(completableFuture.get());




//        CompletableFuture
//                .supplyAsync(()-> "Like and ")
//                .thenApply(supplyResult -> supplyResult + "Subscribe")
//                .thenAccept(thenApplyResult -> System.out.println(thenApplyResult + "!!!"))
//                .get();



        /*
        CompletableFuture
                .supplyAsync(()-> "Like and ")
                .thenApply(supplyResult -> supplyResult + "Subscribe ")
                .thenRun(()-> System.out.println("my channel."))
                .get();
         */


        /*
        CompletableFuture
                .supplyAsync(()-> Thread.currentThread().getName() + " | ")
                .thenApply(supplyResult -> supplyResult + Thread.currentThread().getName() + " | ")
                .thenAccept(thenApplyResult -> System.out.println(thenApplyResult + Thread.currentThread().getName()))
                .get();
        //ForkJoinPool.commonPool-worker-1 | main | main
        // -OR-
        //ForkJoinPool.commonPool-worker-1 | ForkJoinPool.commonPool-worker-1 | ForkJoinPool.commonPool-worker-1
        // -OR-
        //ForkJoinPool.commonPool-worker-1 | ForkJoinPool.commonPool-worker-1 | main
         */


        /* exemplo X
        CompletableFuture<CompletableFuture<Double>> result1 =
                getBankAccount("abc")
                        .thenApply(account -> getAccountBalance(account));//.thenApply(MyCompletableFuture::getAccountBalance);

        CompletableFuture<Double> result2 =
                getBankAccount("abc")
                        .thenCompose(account -> getAccountBalance(account));//.thenCompose(MyCompletableFuture::getAccountBalance);
         */


        /*
        CompletableFuture<Double> positiveFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Retrieving positive number...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200.02;
        });

        CompletableFuture<Double> negativeFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Retrieving negative number...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return -100.01;
        });

        CompletableFuture<Double> combineFuture = positiveFuture.thenCombine(
                negativeFuture, (positiveFutureResult, negativeFutureResult) -> positiveFutureResult - negativeFutureResult
        );

        System.out.println("pos - neg = " + combineFuture.get());
         */


        /*
        CompletableFuture<Double> positiveFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Retrieving positive number...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123.0;
        });

        CompletableFuture<Double> negativeFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Retrieving negative number...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return -99.0;
        });

        positiveFuture.thenAcceptBoth(
                negativeFuture,
                (positiveFutureResult, negativeFutureResult) -> System.out.println(positiveFutureResult - negativeFutureResult)
        ).get();
         */


        /*
        List<CompletableFuture<String>> completableFutures = List.of(
                CompletableFuture.supplyAsync(()-> "Like"),
                CompletableFuture.supplyAsync(()-> "Subscribe"),
                CompletableFuture.supplyAsync(()-> "My Channel")
        );
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[3]))
                .thenAccept(v -> completableFutures.stream().map(CompletableFuture::join).forEach(System.out::println)).get()
         */


        /*
        List<CompletableFuture<String>> completableFutures = List.of(

                CompletableFuture.supplyAsync(()-> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Like";
                }),

                CompletableFuture.supplyAsync(()-> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Subscribe";
                }),

                CompletableFuture.supplyAsync(()-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "My Channel";
                })
        );

        System.out.println(CompletableFuture.anyOf(completableFutures.toArray(new CompletableFuture[3])).get());
         */



        /*
        List<String> myList = new ArrayList<>();
        //myList.add("One");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
            if (myList.isEmpty()) {
                throw new IllegalArgumentException("List provided cannot be empty");
            }
            return "List processed Successfully!";
        }).exceptionally(exception -> {
            System.out.println("Exception: " + exception.getMessage());
            return "Exception Occurred !!";
        });
        System.out.println("Result: " + completableFuture.get());
         */


//        List<String> myList = new ArrayList<>();
//        //myList.add("One");
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
//            if (myList.isEmpty()) {
//                throw new IllegalArgumentException("List provided cannot be empty");
//            }
//            return "List processed Successfully!";
//        }).handle((result, exception) -> {
//            if (exception == null) return result;
//            System.out.println("Exception:" + exception.getMessage());
//            return "Exception Occurred!!";
//        });
//        System.out.println("Result: " + completableFuture.get());






    }

    /* exemplo X
    public static CompletableFuture<BankAccount> getBankAccount(String accId) {
        return CompletableFuture.supplyAsync(()-> AccountsService.getBankAccount(accId));
    }

    public static CompletableFuture<Double> getAccountBalance(BankAccount account) {
        return CompletableFuture.supplyAsync(()-> BalanceService.getAccountBalance(account));
    }
     */
}