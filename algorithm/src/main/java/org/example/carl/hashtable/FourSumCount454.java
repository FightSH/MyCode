package org.example.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 此题不需要考虑重复元素的情况，只是找出数量即可
 */
public class FourSumCount454 {
    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        // 统计两个数组中的元素之和，同时统计出现的次数，并放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
