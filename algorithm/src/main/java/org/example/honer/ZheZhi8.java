package org.example.honer;

import java.util.Scanner;

public class ZheZhi8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bainli(1, true, n);
    }

    private static void bainli(int depth, boolean isLeft, int n) {
        if (depth > n) return;
        bainli(depth + 1, true, n);
        System.out.println(isLeft ? "down" : "up");
        bainli(depth + 1, false, n);
    }
}
