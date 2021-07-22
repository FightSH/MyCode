package org.example.demo.readwirte;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "123").start();
        new WriteThread(data, "456").start();
    }
}
