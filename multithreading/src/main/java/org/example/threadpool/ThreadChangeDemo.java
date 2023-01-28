package org.example.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class ThreadChangeDemo {
    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                new ThreadFactoryBuilder().setNameFormat("shen-pool-%d").build()
        );
    }


    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数" + executor.getCorePoolSize() +
                " 活动线程数:" + executor.getActiveCount() +
                " 最大线程数:" + executor.getMaximumPoolSize() +
                " 线程池活跃度:" + new BigDecimal(executor.getActiveCount() + "").divide(new BigDecimal(executor.getMaximumPoolSize() + ""), 2, RoundingMode.HALF_DOWN) +
                " 任务完成度:" + executor.getCompletedTaskCount() +
                " 队列大小:" + queue.size() + queue.remainingCapacity() +
                " 当前线程排队数:" + queue.size() +
                " 队列剩余大小:" + queue.remainingCapacity()

        );
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.execute(() -> {
                        threadPoolStatus(threadPoolExecutor, "create");
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        TimeUnit.SECONDS.sleep(1);
        threadPoolStatus(threadPoolExecutor, "before change");
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolStatus(threadPoolExecutor, "after change");
        Thread.currentThread().join();
    }
}
