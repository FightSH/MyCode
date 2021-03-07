package org.example.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElement496 {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ints = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.peek(), num);
                stack.pop();
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }


}
