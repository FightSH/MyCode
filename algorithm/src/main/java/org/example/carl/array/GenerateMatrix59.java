package org.example.carl.array;

import java.util.Arrays;

public class GenerateMatrix59 {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] generateMatrix(int num) {
        int[][] nums = new int[num][num];
        int temp = 1;
        int left = 0, right = num - 1, top = 0, button = num - 1;


        while (true) {
            // 横
            for (int i = left; i <= right; i++) {
                nums[left][i] = temp++;
            }
            top++;

            if (top > button) {
                break;
            }

            // 竖
            for (int i = top; i <= button; i++) {
                nums[i][right] = temp++;
            }
            right--;
            if (left > right) {
                break;
            }

            // 横
            for (int i = right; i >= left; i--) {
                nums[button][i] = temp++;
            }
            button--;
            if (top > button) {
                break;
            }

            // 竖
            for (int i = button; i >= top; i--) {
                nums[i][left] = temp++;
            }
            left++;
            if (left > right) {
                break;
            }




        }

        return nums;
    }


}
