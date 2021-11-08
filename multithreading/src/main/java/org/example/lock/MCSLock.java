package org.example.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * MCS SpinLock是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只能在本地变量上自旋，
 * 直接前驱负责通知其结束自旋，从而极大的减少了不必要的处理器缓存同步的次数，降低了总线和内存的开销
 */
public class MCSLock {
    public static class MSCNode {
        volatile MSCNode next;
        volatile boolean isBlock = true;
    }

    volatile MSCNode queue;

    private static final AtomicReferenceFieldUpdater<MCSLock, MSCNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MSCNode.class, "queue");

    public void lock(MSCNode currentThread) {
        // get旧值，set新值
        MSCNode predecessor = UPDATER.getAndSet(this, currentThread);   // step 1
        if (predecessor != null) {
            predecessor.next = currentThread;   // step 2

            while (currentThread.isBlock) {    // step 3

            }

        } else { // 只有一个线程在使用锁，没有前驱进行通知，所以需要自己标记自己为非阻塞
            currentThread.isBlock = false;
        }


    }


    public void unLock(MSCNode currentThread) {
        if (currentThread.isBlock) {
            return;
        }
        if (currentThread.next == null) {
            if (UPDATER.compareAndSet(this, currentThread, null)) {// step 4
                // compareAndSet返回true表示确实没有人排在自己后面
                return;
            } else {
                // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
                // 这里之所以要忙等是因为：step 1执行完后，step 2可能还没执行完
                while (currentThread.next == null) { // step 5
                }
            }
        }

        currentThread.next.isBlock = false;
        currentThread.next = null;// for GC
    }

}
