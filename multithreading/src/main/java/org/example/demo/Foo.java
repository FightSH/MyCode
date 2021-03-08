package org.example.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Foo {

    private int flag = 0;


    private ReentrantLock reentrantLock = new ReentrantLock();




    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (flag == 1) {
                reentrantLock.lock();
                break;
            }
        }


        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        flag = 2;
        reentrantLock.unlock();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (flag == 2) {
                break;
            }
        }


        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
        reentrantLock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (true) {
            if (flag == 3) {
                break;
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        reentrantLock.unlock();
    }

}
