package org.example.leetcode.array;

/**
 * @author SH
 * @date 2021/7/9 12:02
 */
public class MajorityElement1710 {
    public int majorityElement(int[] nums) {
        int can = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                can = num;
            }
            if (can == num) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == can) {
                count++;
            }
        }
        return count * 2 > length ? can : -1;
    }
}
