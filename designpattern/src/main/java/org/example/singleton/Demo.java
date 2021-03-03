package org.example.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Demo {

    public static void main(String[] args) {


        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance());
            }
        };

        for (int i = 0; i < 100; i++) {
            executorService.execute(runnable);
        }



    }

}
