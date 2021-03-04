package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {


    public static List<Integer> spiralOrder(int[][] matrix) {

        final List<Integer> list = new ArrayList<>();
        final int height = matrix.length;
        final int width = matrix[0].length;

        int left = 0, right = width - 1, top = 0, button = height - 1;

        while (true) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > button) {
                break;
            }

            for (int i = top; i <= button; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }


            for (int i = right; i >= left; i--) {
                list.add(matrix[button][i]);
            }
            button--;
            if (top > button) {
                break;
            }

            for (int i = button; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (right < left) {
                break;
            }


        }
        return list;
    }


}
