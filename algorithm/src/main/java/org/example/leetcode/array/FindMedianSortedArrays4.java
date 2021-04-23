package org.example.leetcode.array;

import java.util.Arrays;

public class FindMedianSortedArrays4 {
    public static void main(String[] args) {

        int[] ints = { 1,2};
        int[] ints1 = {3};
        System.out.println(findMedianSortedArrays(ints, ints1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] array = new int[nums1.length + nums2.length];

        int index = 0, temp1 = 0, temp2 = 0;


        while (temp1 < nums1.length && temp2 < nums2.length) {
            if (nums1[temp1] >= nums2[temp2]) {
                array[index++] = nums2[temp2++];
            } else {
                array[index++] = nums1[temp1++];
            }
        }

        while (temp1 < nums1.length) {
            array[index++] = nums1[temp1++];
        }
        while (temp2 < nums2.length) {
            array[index++] = nums2[temp2++];
        }
        if (array.length == 1) {
            return (double)array[0];
        }

        if (array.length % 2 == 0) {
            return (double) (array[array.length / 2-1] + array[array.length / 2 ]) / 2;

        } else {
            return (double) (array[array.length / 2 ]);

        }


    }
}
