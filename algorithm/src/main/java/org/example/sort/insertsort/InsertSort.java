package org.example.sort.insertsort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arrays = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insertSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void insertSort(int[] arrays) {
        int length = arrays.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && arrays[j] < arrays[j - 1]; j--) {
                int temp = arrays[j];
                arrays[j] = arrays[j - 1];
                arrays[j - 1] = temp;
            }
        }
    }
}
