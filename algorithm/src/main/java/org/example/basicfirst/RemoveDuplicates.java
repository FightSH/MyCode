package org.example.basicfirst;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {-3, -1, 0, 0};
        System.out.println(removeDuplicatesOne(nums));
        System.out.println(removeDuplicatesTwo(nums));

    }

    public static int removeDuplicatesOne(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return length;
        }
        int a;
        int max = nums[0];
        int tempSub = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录当前最大值和其下标，找到下一个更大的值后，更新即可
            a = i;
            if (max > nums[i]) {
                continue;
            }
            while (++a < length) {
                if (nums[a] > nums[i]) {
                    nums[i + 1] = nums[a];
                    max = nums[a];
                    tempSub = ++i;
                }
            }
        }
        return tempSub + 1;
    }


    public static int removeDuplicatesTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }

        return ++left;
    }

}
