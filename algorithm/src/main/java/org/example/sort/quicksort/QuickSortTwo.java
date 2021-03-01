package org.example.sort.quicksort;

import java.util.Arrays;

public class QuickSortTwo {


    public static void main(String[] args) {
        int[] ints = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        QuickSortOne quickSort = new QuickSortOne();
        int[] array = quickSort.sortArray(ints);
        System.out.println(Arrays.toString(array));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {


        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }


    }

    private int partition(int[] nums, int left, int right) {
        int num = nums[left];
        int start = left;

        while (left < right) {

            while (left < right && nums[left] <= num) {
                left++;
            }
            while (left < right && nums[right] >= num) {
                right++;
            }
            if (left >= right) {
                break;
            }
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right] = temp;

        }
        int temp = nums[start];
        nums[left]=nums[start];
        nums[start] = temp;


        return right;
    }
}
