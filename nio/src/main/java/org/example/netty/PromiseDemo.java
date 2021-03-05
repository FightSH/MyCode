package org.example.netty;

import io.netty.util.concurrent.*;

public class PromiseDemo {

    public static void main(String[] args) {

        final DefaultEventExecutor eventExecutors = new DefaultEventExecutor();

        final Promise defaultPromise = new DefaultPromise<>(eventExecutors);

        defaultPromise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("任务完成成功，结果：" + future.get());
                } else {
                    System.out.println("任务完成失败,cause:" + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("任务结束，balabala...");
            }
        });


        eventExecutors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                // 设置 promise 的结果
                defaultPromise.setFailure(new RuntimeException());
//                defaultPromise.setSuccess(123456);
            }
        });

        // main 线程阻塞等待执行结果
        try {
            defaultPromise.await();
//            defaultPromise.await();
        } catch (InterruptedException e) {
        }


    }

}
