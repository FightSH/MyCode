package org.example.carl.hashtable;

import java.util.HashSet;

public class IsHappy202 {

    public static void main(String[] args) {


        final Solution solution = new Solution();
        final int i = 19 % 10;
        System.out.println(solution.isHappy(19));

    }

    static class Solution {

        public boolean isHappy(int n) {

            final HashSet<Integer> set = new HashSet<>();

            while (true) {

                int sum = 0;

                while (n !=0) {
                    final int i = n % 10;
                    sum += i * i;
                    n = n/10;
                }

                if (sum == 1) {
                    return true;
                }

                if (set.contains(sum)) {
                    return false;
                }

                set.add(sum);

                n = sum;

            }

        }
    }
}
