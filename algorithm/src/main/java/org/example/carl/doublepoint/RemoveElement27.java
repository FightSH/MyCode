package org.example.carl.doublepoint;

public class RemoveElement27 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {

        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[a] = nums[i];
                a++;
            }
        }
        return a;
    }
}