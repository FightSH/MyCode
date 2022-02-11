package org.example.carl.array;

import java.util.Arrays;

public class MinimumDifference1984 {


    public static void main(String[] args) {
        int[] nums = {9};
        System.out.println(minimumDifference(nums, 1));
    }

    public static int minimumDifference(int[] nums, int k) {


        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i + k - 1 > nums.length - 1) {
                break;
            }
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }

        return min;
    }


}
