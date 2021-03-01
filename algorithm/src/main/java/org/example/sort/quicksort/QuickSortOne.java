package org.example.sort.quicksort;

import java.util.Arrays;

/**
 * https://mp.weixin.qq.com/s?__biz=Mzg3NDU4MDQ3Mw==&mid=2247491853&idx=1&sn=ebdf29c58fb6456f181bb58162f3d557&chksm=cecc319bf9bbb88d3da01d5c170c26b2fa381aec6c72cb63c36a4128e11cc7d7631d9f3810fa&cur_album_id=1751074851034857475&scene=189#rd
 */
public class QuickSortOne {


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
        while (left < right) {
            while (left < right && nums[right] >= num) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }

            while (left < right && nums[left] <= num) {
                left++;
            }

            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[right] = num;
        return right;
    }


}
