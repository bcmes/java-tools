package com.bcms.apache.threads.virtual;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Um exemplo mais real..
public class VirtualThreadDemo2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        Future<String> f1 = service.submit(() -> get("https://horstmann.com/random/adjective"));
        Future<String> f2 = service.submit(() -> get("https://horstmann.com/random/noun"));
        String result = f1.get() + " " + f2.get(); //Agora o bloqueio é barato
        System.out.println(result);
        service.close();
    }

    private static HttpClient client = HttpClient.newHttpClient();

    public static String get(String url) {
        try {
            var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            var rex = new RuntimeException();
            rex.initCause(ex);
            throw rex;
        }
    }
}
