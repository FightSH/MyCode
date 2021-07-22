package org.example.demo.readwirte;

public class ReadWriteLock {
    // 实际正在读取中的线程个数
    private int readingReaders = 0;
    // 正在等待写入的线程个数
    private int waitingWriters = 0;
    // 实际正在写入中的线程个数
    private int writingWriters = 0;
    // 若写入优先，则为true
    private boolean preferWriter = true;

    /**
     * 读锁。线程线程在读的时候，检查是否有写线程在执行，如果有就需要等待。同时还会观察，在写入优先的时候，是否有等待写入的线程。
     * 如果存在也需要等待，等待写入操作的线程完成再执行。如果以上条件都没有满足，那么进行读操作，并将读取线程数 +1。
     *
     * @throws InterruptedException
     */
    public synchronized void readLock() throws InterruptedException {
        // 有线程在写或有线程在等待写
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    /**
     * 读解锁。线程在读操作完成以后，将读取线程数 -1。通知其他等待线程执行。
     *
     * @throws InterruptedException
     */
    public synchronized void readUnLock() throws InterruptedException {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    /**
     * 写锁。先将写等待线程数 +1。如果发现有正在读的线程或者有正写的线程，那么进入等待。否则，进行写操作，并将正在写操作线程数 +1。
     *
     * @throws InterruptedException
     */
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    /**
     * 写解锁。线程在写操作完成以后，将写线程数 -1。通知其他等待线程执行。
     *
     * @throws InterruptedException
     */
    public synchronized void writeUnLock() throws InterruptedException {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }

}
