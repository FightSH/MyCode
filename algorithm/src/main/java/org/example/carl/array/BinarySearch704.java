package org.example.carl.array;

import java.util.Arrays;

public class BinarySearch704 {


    public static void main(String[] args) {

        Solution solution = new Solution();

        int search = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }


    static class Solution {
        // 注意点，如果是左闭右必区间的话，注意边界条件
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (target < nums[mid]) {
                    end = mid - 1;
                }
                if (target > nums[mid]) {
                    start = mid + 1;
                }

            }


            return -1;
        }
    }


}

