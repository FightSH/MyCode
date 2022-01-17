package org.example.carl.hashtable;

import java.util.HashSet;
import java.util.Set;

public class IsHappy202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }


        return n == 1;
    }


    public static int getSum(int n) {
        int res = 0;
        while (n > 0) {
            int a = n % 10;
            res += a * a;
            n = n / 10;
        }
        return res;

    }

}
