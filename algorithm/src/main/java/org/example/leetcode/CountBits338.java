package org.example.leetcode;

public class CountBits338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        final int[] arrays = new int[num + 1];
        arrays[0] = 0;
        for (int i = 1; i <= num; i++) {

            if (i % 2 == 1) {
                arrays[i] = arrays[i - 1] + 1;
            } else {
                arrays[i] = arrays[i / 2];
            }
        }

        return arrays;
    }




}
