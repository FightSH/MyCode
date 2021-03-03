package org.example.sort.mergesort;

import java.util.Arrays;

public class MergeSortOne {


    public static void main(String[] args) {
        int[] arrays = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        mergeSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));

    }

    private static void mergeSort(int[] arrays, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arrays, left, mid);
            mergeSort(arrays, mid + 1, right);
            merge(arrays, left, mid, right);
        }
    }

    private static void merge(int[] arrays, int left, int mid, int right) {
        final int[] ints = new int[right - left + 1];
        int temp1 = left;
        int temp2 = mid + 1;
        int index = 0;

        while (temp1 <= mid && temp2 <= right) {
            if (arrays[temp1] >= arrays[temp2]) {
                ints[index++] = arrays[temp2++];
            } else {
                ints[index++] = arrays[temp1++];
            }
        }

        while (temp1 <= mid) {
            ints[index++] = arrays[temp1++];
        }
        while (temp2 <= right) {
            ints[index++] = arrays[temp2++];
        }


        System.arraycopy(ints,0,arrays,left,ints.length);



    }


}
