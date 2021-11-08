package org.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * 需要注意Phaser的树状结构
 */
public class PhaserDemo {


    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        // register 会使得 parties 加 1
        phaser.register();
        for (int i = 0; i < 10; i++) {
            phaser.register();
            executorService.submit(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("sleep...");
        Thread.sleep(3000);
        // 当前线程抵达栅栏并且等待
        phaser.arriveAndAwaitAdvance();
    }


}
