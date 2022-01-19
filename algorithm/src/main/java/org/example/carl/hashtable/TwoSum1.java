package org.example.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {


    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];

            if (map.containsKey(a)) {
                res[0] = i;
                res[1] = map.get(a);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

}
