package org.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static int count = 500;

    public static void main(String[] args) {
        final ExecutorService threadPool = Executors.newFixedThreadPool(300);

        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < count; i++) {
            final int threadNum = i;
            threadPool.execute(()->{
                try {
                    semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
                    test(threadNum);
                    semaphore.release();// 释放一个许可
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");




    }


    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }

}
