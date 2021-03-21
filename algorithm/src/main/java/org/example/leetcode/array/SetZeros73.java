package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class SetZeros73 {


    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> x = new HashSet<>();
        HashSet<Integer> y = new HashSet<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x.add(j);
                    y.add(i);
                }
            }
        }
        //根据 x，y的值，将数组置为0

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (x.contains(j) || y.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }


    }

}
