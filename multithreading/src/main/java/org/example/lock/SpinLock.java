package org.example.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 简单的自旋锁，通过CAS实现。适合锁占用时间很短的场景(即锁保护临界区很小的情况)
 * 缺点：无法保证公平性；
 */
public class SpinLock {


    private AtomicReference<Thread> owner = new AtomicReference<>();


    public void lock() {
        Thread thread = Thread.currentThread();
        while (!owner.compareAndSet(null, thread)) {

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        owner.compareAndSet(thread, null);
    }

}
