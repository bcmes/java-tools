package com.bcms.apache.threads.virtual;

public class VirtualThreadDemo {
//    public static void main(String[] args) {
//        final int NTASKS = 100;
//        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
//        for (int i = 0; i < NTASKS; i++) {
//            //executa cada tarefa em um thread virtual separado.
//            service.submit(() -> {
//                long id = Thread.currentThread().threadId();
//                //LockSupport.parkNanos em vez de Thread.sleep para nao lancar InterruptedException.
//                LockSupport.parkNanos(1_000_000_000);
//                System.out.println(id);
//            });
//        }
//        service.close();
//    }
}
