package org.example.leetcode;

/**
 * 前缀和求解
 *
 * 类似阴影面积求和
 *
 * 1.考虑对应矩阵下标的前缀和
 * 2.考虑指定范围内的和如何由前缀和得来
 * 3.具体下标需要仔细考虑
 *
 */
public class NumMatrix304 {

    int[][] sums;


    public NumMatrix304(int[][] matrix) {

        final int m = matrix.length;
        if (m > 0) {
            final int n = matrix[0].length;

            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] + matrix[i][i] - sums[i][j];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2][col1 + 1] + sums[row1][col1];

    }

}
