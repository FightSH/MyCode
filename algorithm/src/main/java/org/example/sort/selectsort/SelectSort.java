package org.example.sort.selectsort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arrays = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        selectSort(arrays);
        System.out.println(Arrays.toString(arrays));

    }

    private static void selectSort(int[] arrays) {
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }
            int temp = arrays[min];
            arrays[min] = arrays[i];
            arrays[i] = temp;

        }


    }
}
