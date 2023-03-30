package org.example.carl.array;

/**
 * 长度最小子数组
 */
public class MinSubArrayLen209 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5}));
    }

    static class Solution {

        public int minSubArrayLen(int target, int[] nums) {

            int len = Integer.MAX_VALUE;
            if (nums[0] == target) {
                return 1;
            }
            int sum = 0;
            int leftIndex = 0;

            for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {

                sum += nums[rightIndex];

                while (sum >= target) {
                    len = Math.min(len, rightIndex - leftIndex + 1);
                    sum -= nums[leftIndex];
                    leftIndex++;
                }
            }

            return len == Integer.MAX_VALUE ? 0 : len;


        }

        public int minSubArrayLen2(int target, int[] nums) {
            int res = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            int subLength;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                // 此处使用while，每次更新起始位置i，并不断比较子序列是否符合条件
                while (sum >= target) {
                    subLength = right - left + 1; // 取子序列的长度
                    res = Math.min(res, subLength);
                    sum -= nums[left++]; // 根据子序列和大小的情况，不断调节子序列的其实位置
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }


}
