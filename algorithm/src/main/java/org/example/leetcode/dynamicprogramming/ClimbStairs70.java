package org.example.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SH
 * @date 2021/6/28 9:51
 */
public class ClimbStairs70 {

    private static Map<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {
        //f(n) = f(n-1)+f(n-2)
        //f(1) = 1,f(2) = 2
        //可将一些值缓存起来
        long time = System.currentTimeMillis();
        System.out.println(climbStairs(45));
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (!map.containsKey(n)) {
            map.put(n, climbStairs(n - 2) + climbStairs(n - 1));
        }
        return map.get(n);

    }
}
