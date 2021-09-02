package org.example.aqs;

public class WaitExercise {

    private int signal = 0;


    private synchronized void a() {

        while (signal != 0) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("a");
        signal++;
        notifyAll();


    }


    private synchronized void b() {

        while (signal != 1) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("b");
        signal++;
        notifyAll();


    }

    private synchronized void c() {
        while (signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("c");
        signal = 0;
        notifyAll();


    }


    static class A implements Runnable {
        private WaitExercise e;

        public A(WaitExercise e) {
            this.e = e;

        }

        @Override
        public void run() {
            while (true) {
                e.a();
            }
        }
    }

    static class B implements Runnable {
        private WaitExercise e;

        public B(WaitExercise e) {
            this.e = e;

        }

        @Override
        public void run() {
            while (true) {
                e.b();
            }
        }
    }
    static class C implements Runnable {
        private WaitExercise e;

        public C(WaitExercise e) {
            this.e = e;

        }

        @Override
        public void run() {
            while (true) {
                e.c();
            }
        }
    }

    public static void main(String[] args) {

        final WaitExercise waitExercise = new WaitExercise();

        final A a = new A(waitExercise);
        final B b = new B(waitExercise);
        final C c = new C(waitExercise);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();


    }

}
