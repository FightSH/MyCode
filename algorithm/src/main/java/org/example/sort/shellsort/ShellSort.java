package org.example.sort.shellsort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arrays = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        shellSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void shellSort(int[] arrays) {
        //关键定义一个递减序列
        int length = arrays.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && arrays[j] < arrays[j - h]; j = j - h) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j - h];
                    arrays[j - h] = temp;
                }
            }
            h = h / 3;
        }

    }
}
