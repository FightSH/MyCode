package org.example.honer;

import org.example.leetcode.string.MaxPower1446;

import java.util.Arrays;

public class Question26 {
    public static void main(String[] args) {
        int arr[] = {9, 3, 1, 10};
        Arrays.sort(arr);
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i]  -arr[i - 1]);
        }
        System.out.println(res);
    }
}
