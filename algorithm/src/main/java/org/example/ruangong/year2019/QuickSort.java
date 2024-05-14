package org.example.ruangong.year2019;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {


        int[] arr = {5, 7, 8, 6, 2, 1, 9, 4, 3};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));


    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int m = partition(arr, start, end);
            quickSort(arr, start, m - 1);
            quickSort(arr, m + 1, end);
        }


    }

    private static int partition(int[] arr, int low, int high) {
        int p = arr[low];
        while (low < high) {
            while (low < high && p <= arr[high]) high--;
            arr[low] = arr[high];
            while (low < high && p >= arr[low]) low++;
            arr[high] = arr[low];
            arr[low] = p;
        }
        return low;
    }
}
