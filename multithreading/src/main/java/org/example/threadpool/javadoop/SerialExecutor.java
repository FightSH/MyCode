package org.example.threadpool.javadoop;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * 将所有任务加入到一个队列中，另外去线程进行消费
 */
public class SerialExecutor implements Executor {


    final Queue<Runnable> tasks = new ArrayDeque<>();

    final Executor executor;

    Runnable active;

    public SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public synchronized void execute(Runnable command) {
        tasks.offer(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                } finally {
                    scheduleNext();
                }
            }

        });



    }

    private synchronized void scheduleNext() {

        if ((active = tasks.poll()) != null) {
            executor.execute(active);
        }

    }
}
