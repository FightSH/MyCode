package org.example.carl.hashtable;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            final int[] res = new int[2];

            final HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                final int num = nums[i];
                final int i1 = target - num;
                if (map.containsKey(i1)) {
                    return new int[]{i, map.get(i1)};
                }
                map.put(num, i);
            }

            return res;
        }
    }
}
