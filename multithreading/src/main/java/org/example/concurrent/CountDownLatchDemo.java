package org.example.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch downLatch1 = new CountDownLatch(3);
        CountDownLatch downLatch2 = new CountDownLatch(1);


        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        downLatch2.await();
                        System.out.println(Thread.currentThread().getName() + " id do something...");
                        downLatch1.countDown();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println(Thread.currentThread().getName() + " is ready");
        downLatch2.countDown();

        downLatch1.await();

    }




}
