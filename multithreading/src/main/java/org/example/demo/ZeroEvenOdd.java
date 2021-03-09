package org.example.demo;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    private final Object object = new Object();
    private int x = 1;
    private boolean flag = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (x<=n) {
            synchronized (object) {
                if (flag) {
                    printNumber.accept(0);
                    flag = false;

                    object.notifyAll();
                } else {
                    object.wait();
                }
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (x<=n) {
            synchronized (object) {
                if (!flag && x % 2 == 0) {
                    flag = true;
                    printNumber.accept(x);
                    x++;
                    object.notifyAll();
                } else {
                    object.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (x<=n) {
            synchronized (object) {
                if (!flag && x % 2 != 0) {
                    flag = true;
                    printNumber.accept(x);
                    x++;
                    object.notifyAll();
                } else {
                    object.wait();
                }
            }
        }
    }

    public static void main(String[] args) {

        final IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
        final ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
