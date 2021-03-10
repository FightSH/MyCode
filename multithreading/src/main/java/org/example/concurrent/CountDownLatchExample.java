package org.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountDownLatchExample {
    private static int count = 500;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(250);

        final CountDownLatch downLatch = new CountDownLatch(500);

        for (int i = 0; i < count; i++) {
            final int threadNum = i;
            threadPool.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally {
                    downLatch.countDown();

                }
            });
        }
        downLatch.await();
        System.out.println("finish");
        threadPool.shutdown();




    }


    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }

}
