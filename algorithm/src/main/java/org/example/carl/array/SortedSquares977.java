package org.example.carl.array;

import java.util.Arrays;

public class SortedSquares977 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] res = solution.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] sortedSquares(int[] nums) {

            int[] res = new int[nums.length];
            int k = nums.length - 1;
            for (int left = 0, right = nums.length - 1; left <= right; ) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    res[k--] = nums[left] * nums[left];
                    left++;
                } else {
                    res[k--] = nums[right] * nums[right];
                    right--;
                }

            }
            return res;
        }
    }

}
