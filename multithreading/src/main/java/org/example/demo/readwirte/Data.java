package org.example.demo.readwirte;

import java.util.Arrays;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnLock();
        }

    }

    public void write(char[] c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnLock();
        }
    }

    private char[] doRead() {
        return buffer;
    }

    private void doWrite(char[] c) {
        for (int i = 0; i < c.length; i++) {
            buffer[i] = c[i];
        }
    }

}
