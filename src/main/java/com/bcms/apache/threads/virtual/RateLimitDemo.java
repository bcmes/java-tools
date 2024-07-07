package com.bcms.apache.threads.virtual;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * O programa de exemplo a seguir mostra a limitação de taxa com um semáforo simples
 * que permite um pequeno número de solicitações simultâneas.
 */
public class RateLimitDemo {
   public static void main(String[] args) throws InterruptedException, ExecutionException {

      ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
      List<Future<String>> futures = new ArrayList<>();
      final int TASKS = 250;
      for (int i = 1; i <= TASKS; i++)
         futures.add(service.submit(() -> get("https://horstmann.com/random/word")));

      for (Future<String> f : futures)
         System.out.println(f.get() + " ");
      System.out.println();
      service.close();
   }

   private static HttpClient client = HttpClient.newHttpClient();

   private static final Semaphore SEMAPHORE = new Semaphore(20); //cool.. vai 20 por vez!
   
   public static String get(String url) {
      try {
         var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
         SEMAPHORE.acquire();
         try {
            Thread.sleep(100);
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
         } finally {
            SEMAPHORE.release();
         }
      } catch (Exception ex) {
         ex.printStackTrace();
         var rex = new RuntimeException();
         rex.initCause(ex);
         throw rex;
      }
   }   
}
