package org.example.leetcode.array;

public class RotaryArray33 {

    public static void main(String[] args) {
        int[] arr = { 1};
        System.out.println(search(arr,0));
    }


    public static int search(int[] nums, int target) {
        //原数组是升序的，因此只要找到那个翻转点，就可判断是否存在

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (i > 0) {
                //说明 i 是原数组最后一个单位
                if (nums[i] < nums[i - 1]) {
                    if (target > nums[i - 1]) {
                        return -1;
                    }
                }
            }

        }
        return -1;
    }
}
