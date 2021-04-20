package org.example.leetcode.array;

import java.util.Arrays;

public class RemoveElement27 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
    }


    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                }
            } else {
                i++;
            }
            j++;


        }


        return i;


    }
}
