package org.example.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 排队自旋锁解决了公平性的问题，但是在多线程处理系统上，每个进程/线程占用的处理器都在读写同一个变量serviceNum，
 * 每次读写操作都必须在多个处理器缓存之间进行缓存同步，这会导致繁重的系统总线和内存的流量，大大降低系统整体的性能。
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger(); // 服务号
    private AtomicInteger ticketNum = new AtomicInteger(); // 排队号


    public int lock() {
        int myTickerNum = ticketNum.getAndIncrement();
        while (serviceNum.get() != myTickerNum) {

        }
        return myTickerNum;
    }

    public void unLock(int myTicket) {
        int next = myTicket + 1;
        serviceNum.compareAndSet(myTicket, next);
    }

}
