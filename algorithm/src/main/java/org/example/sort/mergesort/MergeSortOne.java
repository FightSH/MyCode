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
            int mid = left + ((right - left) >> 1);
            mergeSort(arrays, left, mid);
            mergeSort(arrays, mid + 1, right);
            merge(arrays, left, mid, right);
        }
    }

    private static void merge(int[] arrays, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int temp1 = left;
        int temp2 = mid + 1;
        int index = 0;

        while (temp1 <= mid && temp2 <= right) {
            if (arrays[temp1] > arrays[temp2]) {
                tempArr[index++] = arrays[temp2++];
            } else {
                tempArr[index++] = arrays[temp1++];
            }
        }
        while (temp1 <= mid) {
            tempArr[index++] = arrays[temp1++];
        }
        while (temp2 <= right) {
            tempArr[index++] = arrays[temp2++];
        }


        System.arraycopy(tempArr,0,arrays,left,tempArr.length);

    }


}
