package org.example.demo;

public class H2O {


    public H2O() {

    }
    //氢需要等另一个氧和另一个氢
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            releaseHydrogen.run();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

    }
    //氧元素需要等另两个氢元素
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            releaseOxygen.run();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
    }


}
