package org.example.leetcode.array;

import java.util.Arrays;

public class GenerateMatrix59 {


    public static void main(String[] args) {
        final int[][] ints = generateMatrix(1);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }


    }


    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int left = 0, right = n - 1, top = 0, button = n - 1;

        int a = 1;
        while (true) {


            for (int i = left; i <= right; i++) {
                matrix[top][i] = a++;
            }

            top++;
            if (top > button) {
                break;
            }

            for (int i = top; i <= button; i++) {
                matrix[i][right] = a++;
            }

            right--;
            if (left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                matrix[button][i] = a++;
            }

            button--;
            if (top > button) {
                break;
            }

            for (int i = button; i >= top; i--) {
                matrix[i][left] = a++;
            }
            left++;
            if (left > right) {
                break;
            }

            if (a == n) {
                break;
            }

        }


        return matrix;
    }


}
