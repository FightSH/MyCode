package org.example.demo.readwirte;

import java.util.Random;

public class WriteThread extends Thread {
    private static final Random random = new Random();
    public final Data data;
    private final String filter;
    private int index = 0;

    public WriteThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try {
            while (true) {
//                char c = nextChar();
                data.write(filter.toCharArray());
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }
        return c;
    }
}
