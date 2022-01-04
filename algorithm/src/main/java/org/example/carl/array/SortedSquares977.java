package org.example.carl.array;

import java.util.Arrays;

/**
 * 注意 本身数组是有序的，不过有正有负数，如果直接平方，大小关系可能改变
 */
public class SortedSquares977 {

    public static void main(String[] args) {
        int[] ints = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(ints)));
    }


    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] res = new int[nums.length];

        for (int i = res.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }


        return res;
    }


}
