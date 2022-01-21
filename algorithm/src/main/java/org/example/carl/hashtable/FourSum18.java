package org.example.carl.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        List<List<Integer>> list = fourSum(nums, target);

        System.out.println(list);
    }

    /**
     * 两层for循环nums[k] + nums[i]为确定值，循环内有left和right下标作为双指针，
     * 找出nums[k] + nums[i] + nums[left] + nums[right] == target
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            // 注意不能加下面的代码，
//            if (nums[i] > target) {
//                break;
//            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (nums[j] == nums[j - 1] && j > i + 1) {
                    continue;
                }


                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int n = nums[i] + nums[j] + nums[left] + nums[right];
                    if (n > target) {
                        right--;
                    } else if (n < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

}
