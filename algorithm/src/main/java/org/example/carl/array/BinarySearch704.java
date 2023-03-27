package org.example.carl.array;

import java.util.Arrays;

public class BinarySearch704 {


    public static void main(String[] args) {

        Solution solution = new Solution();

        int search = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }


    static class Solution{
        // 注意点，如果是左闭右必区间的话，注意边界条件
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] > target) {
                    right = middle - 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else if (nums[middle] == target) {
                    return middle;
                }
            }
            return -1;
        }
    }


}
