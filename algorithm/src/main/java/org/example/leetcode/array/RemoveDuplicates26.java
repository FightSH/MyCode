package org.example.leetcode.array;

public class RemoveDuplicates26 {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = i + 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }


        return i + 1;
    }
}
