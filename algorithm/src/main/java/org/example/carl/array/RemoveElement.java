package org.example.carl.array;

import java.util.Arrays;

/**
 * 在数组中，无法单独删除数组中的某个元素，只能进行元素的覆盖
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
//        System.out.println(removeElementOne(nums, val));
        System.out.println(removeElementTwo(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElementOne(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 下标i之后的数值都向前移动了一位，所以i也向前移动了一位
                length--; // 此时数组大小-1
            }
        }
        return length;
    }

    public static int removeElementTwo(int[] nums, int val) {

        int left = 0, right = 0; // 双指针
        int length = nums.length; //

        while (right < length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }


        return left;
    }
}
