package org.example.exercises6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App6 {
    public static void main(String[] args) throws InterruptedException {
        //6
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new ThreadRunnable());
        List<Future<Integer>> listFuture = new ArrayList<>();

        for (int i = 0; i < 20000; i++) {
            System.out.println(listFuture.add(service.submit(new ThreadCallable())));
        }
        Integer count = 0;
        System.out.println(listFuture.size());

        for (Future<Integer> future : listFuture) {
            try {
                count += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        service.shutdown();
        boolean flag = service.awaitTermination(60, TimeUnit.SECONDS);
        if (flag) {
            System.out.println("Se cerraron todos los hilos.");
        } else {
            System.out.println("Algunos hilos no se cerraron correctamente.");
        }



    }
}