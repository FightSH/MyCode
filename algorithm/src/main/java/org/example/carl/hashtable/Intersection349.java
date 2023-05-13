package org.example.carl.hashtable;

import java.util.HashSet;

public class Intersection349 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                if (set1.contains(i)) {
                    set2.add(i);
                }

            }
            return set2.stream().mapToInt(x -> x).toArray();
        }


        public int[] intersection2(int[] nums1, int[] nums2) {

            int[] ints = new int[1000];
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums1) {
                ints[i]++;
            }
            for (int i : nums2) {
                if (ints[i] != 0) {
                    set.add(i);
                }
            }
            return set.stream().mapToInt(x -> x).toArray();
        }
    }

}
