package org.example.demo.readwirte;

public class ReadThread extends Thread {

    private final Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + "reads" + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {

        }
        super.run();
    }

}
