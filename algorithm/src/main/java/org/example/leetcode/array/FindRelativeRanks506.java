package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks506 {

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        findRelativeRanks(score);
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int length = score.length;
        String[] res = new String[length];
        int[] clone = score.clone();
        Arrays.sort(clone);
        System.out.println(Arrays.toString(clone));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = length - 1; i >= 0; i--) {
            map.put(clone[i], length - 1 - i);
        }

        for (int i = 0; i < length; i++) {
            int rank = map.get(score[i]);
            res[i] = rank< 3 ? ss[rank] : String.valueOf(rank + 1);
        }

        System.out.println(map);
        return res;
    }
}
