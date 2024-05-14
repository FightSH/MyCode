package org.example.ruangong;

import java.util.Arrays;

public class MoveArrays {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        remove(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

    private static void remove(int[] arr, int i) {

        swap(0, i, arr);
        swap(i + 1, arr.length - 1, arr);
        swap(0,arr.length-1,arr);

    }

    private static void swap(int i, int j, int[] arr) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
