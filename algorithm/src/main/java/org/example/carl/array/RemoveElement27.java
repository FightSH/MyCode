package org.example.carl.array;

public class RemoveElement27 {


    static class Solution{

        // 注意：
        // 快指针用来获取新数组中的元素
        // 慢指针用来获取新数组中元素需要更新的位置
        public int removeElement(int[] nums, int val) {
            int slow = 0;

            for (int fast = 0; fast < nums.length; fast++) {
                if (val != nums[fast]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            return slow;
        }
    }
}
