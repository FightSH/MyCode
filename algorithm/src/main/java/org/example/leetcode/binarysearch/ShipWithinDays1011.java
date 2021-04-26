package org.example.leetcode.binarysearch;

import java.util.Arrays;

public class ShipWithinDays1011 {
    public static void main(String[] args) {

    }


    public static int shipWithinDays(int[] weights, int D) {


        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static boolean check(int[] weights, int D,int limit) {
        int cnt = 1, cur = 0;
        for (int weight : weights) {

            if (limit < weight) {
                return false;
            }
            if(cur+weight>limit){
                cnt++;
                cur = 0;
            }
            cur += weight;
        }
        return cnt <= D;

    }


}
