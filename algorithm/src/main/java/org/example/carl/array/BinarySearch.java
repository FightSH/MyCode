package org.example.carl.array;

/**
 * 二分法的前提：有序数组,并且数组中无重复元素(否则查找的元素下标可能不唯一)
 * 区间的定义就是不变量,要在二分查找的过程中保持不变量，就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作。
 * 这就是循环不变量规则
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = {-1, -100, 2, 3, 99, 100};
        System.out.println(binarySearchOne(nums, 99));
        System.out.println(binarySearchTwo(nums, 99));
    }

    /**
     * 定义target在一个左闭右闭的区间中，即[left, right] 其有以下两点需要注意
     *  while(left<=right)要使用 <= ,因为left==right是有意义的
     *  if(nums[middle]>target) right赋值为middle-1，因为当前的nums[middle]一定不是target。
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchOne(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 定义target在左闭右闭的区间中,[left, right]
        while (left <= right) { // 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else {
                return middle;
            }

        }
        return -1;
    }

    /**
     * 如果 target 定义在一个左闭右开的区间中即[left,right)。那么二分法边界处理就不同
     * while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
     * if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchTwo(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 定义target在左闭右开的区间里，即：[left, right)
        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;// target 在右区间，在[middle + 1, right)中
            } else if (nums[middle] > target) {
                right = middle;// target 在左区间，在[left, middle)中
            } else {
                return middle;
            }

        }
        return -1;
    }

}
