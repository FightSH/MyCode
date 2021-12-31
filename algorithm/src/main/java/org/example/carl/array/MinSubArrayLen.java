package org.example.carl.array;

import java.util.Arrays;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLenOne(nums, 7));
        System.out.println(Arrays.toString(nums));
        System.out.println(minSubArrayLenTwo(nums, 7));
    }

    /**
     * 暴力法。两个for循环，寻找符合条件的子序列。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int minSubArrayLenOne(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int sum = 0; // 子序列数值之和
        int subLength = 0; // 子序列长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列启动为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 子序列终止位置为j
                sum += nums[j];
                if (sum >= target) { // 一旦子序列和超过s,更新res
                    subLength = j - i + 1;
                    res = Math.min(res, subLength); // 找最短子序列，一符合条件就break
                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

    /**
     * 滑动窗口法。所谓滑动窗口，就是不断调节子序列的起始位置和终止位置，从而得到想要的结果
     * 如果使用滑动窗口，需要确定以下三点
     * 窗口内是什么?  窗口就是满足其和 >= s的长度最小的连续子数组
     * 如何移动窗口的起始位置?  如果当前窗口内的值 > s了,窗口就要向前移动了
     * 如何移动窗口的结束位置?  窗口的结束位置就是遍历数组的指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int minSubArrayLenTwo(int[] nums, int target) {
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
