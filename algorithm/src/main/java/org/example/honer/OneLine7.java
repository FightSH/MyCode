package org.example.honer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
// 一条线博弈问题
public class OneLine7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] str = sc.nextLine().split(" ");
        int[] b = new int[a];
        int i = 0;
        while (i < a) {
            b[i] = Integer.parseInt(str[i]);
            i++;
        }
        // 先手和后手一起动规
        int[][] one = new int[a][a];
        int[][] two = new int[a][a];
        int right = 0;
        while (right < a) {
            int left = right;
            while (left >= 0) {
                if (left == right) {
                    // 只剩一张牌，先手的拿
                    one[left][right] = b[left];
                    two[left][right] = 0;
                } else if (right > left) {
                    one[left][right] = Math.max(b[left] + two[left + 1][right], b[right] + two[left][right - 1]);
                    two[left][right] = Math.min(one[left + 1][right], one[left][right - 1]);
                }
                left--;
            }
            right++;
        }
        System.out.println(Math.max(one[0][a - 1], two[0][a - 1]));
    }
}

