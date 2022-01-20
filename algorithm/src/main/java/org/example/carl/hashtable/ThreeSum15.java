package org.example.carl.hashtable;

import java.util.*;

/**
 * 包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 找出所有满足条件且不重复的三元组
 */
public class ThreeSum15 {

    public static void main(String[] args) {


    }

    /**
     * 两层 for 循环可以确定 a 和 b 的值，再使用哈希法来确定 0-(a+b) 是否在数组里出现过
     * 但是此题要求不重复的三元组，需要考虑去重问题
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumHash(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 排序后，如果第一个元素就大于0，说明没有满足条件的元素
            if (nums[i] > 0) {
                break;
            }
            // 元素 a 去重，跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // 元素 b 去重，跳过重复元素
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue;
                }
                int c = -(nums[i] + nums[j]);
                // 如果set中存在c元素，意味着达成一个元组
                if (set.contains(c)) {
                    res.add(Arrays.asList(nums[i], nums[j], c));
                    // 去除已经用过的元素
                    set.remove(c);// 元素 c 去重
                } else {
                    set.add(nums[j]);
                }
            }

        }

        return res;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumDoublePoint(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 此处可否只移动一个指针
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
