package org.example.carl.array;

import java.util.Arrays;

public class GenerateMatrix59 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] matrix = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }


    }

    static class Solution {

        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];

            int start = 0;
            int num = 1;
            int offset = 1;
            int i, j;
            int a = n / 2;
            while (a-- > 0) {

                //左到右
                for ( j = start; j < n - offset; j++) {
                    res[start][j] = num++;
                }


                // 上到下
                for ( i = start; i < n - offset; i++) {
                    res[i][j] = num++;
                }

                // 右到左
                for ( ; j >= offset; j--) {
                    res[i][j] = num++;
                }


                // 下到上
                for (; i >=offset; i--) {
                    res[i][j] = num++;
                }

                start++;
                offset++;

            }

            if (n % 2 != 0) {
                res[start][start] = num;
            }


            return res;
        }
    }

}
