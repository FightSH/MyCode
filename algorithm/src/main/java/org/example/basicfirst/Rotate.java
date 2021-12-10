package org.example.basicfirst;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotateOne(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    // 构建双倍长数组
    public static void rotateOne(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || k % length == 0) {
            return;
        }
        if (k > length) {
            k = k % length;
        }
        int[] copys = new int[2 * length];

        for (int i = 0; i < length; i++) {
            copys[length + i] = nums[i];
            copys[i] = nums[i];
        }
        System.arraycopy(copys, length - k, nums, 0, length);
    }

    public static void rotateTwo(int[] nums, int k) {


    }
}
