package org.example.leetcode.array;

public class SearchMatrix74 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;

        //先二分查找 确定 target可能出现在那一行
        int up = 0, down = height, row = 0;

        while (up < down) {
            row = up + (down - up) / 2;
            if (matrix[row][0] == target || matrix[row][width - 1] == target) {
                return true;
            }
            if (matrix[row][0] < target && matrix[row][width - 1] > target) {
                break;
            }
            if (matrix[row][0] < target) {
                up = row + 1;
            } else if (matrix[row][0] > target) {
                down = row;
            }
        }

        //再二分查找 确定target是否存在于此行

        int left = 0, right = width;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid;
            }
        }
        return false;


    }
}
