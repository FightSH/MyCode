package org.example.carl.hashtable;

import java.util.*;

/**
 * 包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 找出所有满足条件且不重复的三元组
 */
public class ThreeSum15 {

    public static void main(String[] args) {


    }

    public static List<List<Integer>> threeSumHash(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 元素 a 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // 元素 b 去重
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue;
                }
                int c = -(nums[i] + nums[j]);
                if (set.contains(c)) {
                    res.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c);// 元素 c 去重
                } else {
                    set.add(nums[j]);
                }
            }

        }

        return res;
    }

    public static List<List<Integer>> threeSumDoublePoint(int[] nums) {

        return null;
    }
}
