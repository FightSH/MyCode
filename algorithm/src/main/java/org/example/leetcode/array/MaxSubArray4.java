package org.example.leetcode.array;

/**
 * @author SH
 * @date 2021/5/4 18:50
 */
public class MaxSubArray4 {

    public static void main(String[] args) {

        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(ints));

    }

    public static int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max( curSum + nums[i],nums[i]);
            maxSum = Math.max(maxSum, curSum);


        }


        return maxSum;
    }
}
