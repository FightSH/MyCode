package org.example.aqs;

public class WaitNotify {


    public static void main(String[] args) {


        final Object object = new Object();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程1取得监视器锁");
                    try {
                        object.wait();
                        System.out.println("线程1恢复了");
                    } catch (InterruptedException e) {
                        System.out.println("线程1 wait方法抛出异常");
                    }

                }


            }
        }, "线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程2 拿到了监视器锁。为什么呢，因为线程1 在 wait 方法的时候会自动释放锁");
                    System.out.println("线程2 执行 notify 操作");
                    object.notify();
                    System.out.println("线程2 执行完了 notify，先休息3秒再说。");
                    try {
                        Thread.sleep(3000);
                        System.out.println("线程2 休息完啦。注意了，调sleep方法和wait方法不一样，不会释放监视器锁");
                    } catch (InterruptedException ignored) {

                    }
                    System.out.println("线程2 休息够了，结束操作");
                }
            }
        }, "线程2").start();


    }

}
