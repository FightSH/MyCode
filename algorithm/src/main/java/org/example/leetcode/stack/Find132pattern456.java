package org.example.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Find132pattern456 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};

        System.out.println(find132patternTwo(nums));

    }

    //暴力破解法,时间复杂度O(N2)
    //当 i < j < k 时，ai < ak < aj
    // 依次遍历，从 j的左右分别定位 i和k

    public static boolean find132pattern(int[] nums) {
        int length = nums.length;
        int numi = nums[0];

        for (int j = 1; j < length; j++) {
            for (int k = length - 1; k > j; k--) {
                if (numi < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
            numi = Math.min(numi, nums[j]);
        }

        return false;
    }

    //当 i < j < k 时，ai < ak < aj
    //单调栈
    public static boolean find132patternTwo(int[] nums) {
        int length = nums.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.push(nums[length - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                maxK = deque.pop();
            }

            if (nums[i] > maxK) {
                deque.push(nums[i]);
            }
        }

        return false;
    }


}
