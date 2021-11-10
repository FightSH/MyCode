package org.example.leetcode.array;

public class FindPoisonedDuration495 {

    public static void main(String[] args) {
        int[] timeSeries = new int[]{1,  4};
        int duration = 5;
        int res = findPoisonedDuration(timeSeries, duration);
        System.out.println(res);
    }


    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int length = timeSeries.length;
        if (length == 1) {
            return duration;
        }

        for (int i = 0; i < length; i++) {

            if (i == 0) {
                continue;
            }


            if (timeSeries[i] - timeSeries[i - 1] < duration) {
                res += (timeSeries[i] - timeSeries[i - 1]);
            } else {
                res += duration;
            }

            if (i == length - 1) {
                res += duration;
            }

        }

        return res;
    }


}
