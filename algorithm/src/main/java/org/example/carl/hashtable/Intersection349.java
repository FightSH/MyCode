package org.example.carl.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Intersection349 {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }

        int[] ints = new int[res.size()];
        int index = 0;
        for (Integer i : res) {
            ints[index++] = i;
        }
        return ints;
    }
}
