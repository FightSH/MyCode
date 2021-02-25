package org.example.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

         CountDownLatch downLatch1 = new CountDownLatch(3);
         CountDownLatch downLatch2 = new CountDownLatch(1);


        for (int i = 0; i < 3; i++) {
            new Thread(new CountDownLatchDemo.Worker(downLatch2, downLatch1)).start();
        }

        System.out.println(Thread.currentThread().getName() + " is ready" );
        downLatch2.countDown();

        downLatch1.await();

    }

    public static class Worker implements Runnable {

        private final CountDownLatch countDownLatch;
        private final CountDownLatch countDownLatch2;

        public Worker(CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
            this.countDownLatch = countDownLatch;
            this.countDownLatch2 = countDownLatch2;
        }

        @Override
        public void run() {

            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " id do something...");
                countDownLatch2.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


}
