package org.example.leetcode.string;

/**
 * @author SH
 * @date 2021/5/3 12:00
 */
public class Reverse7 {
    public static void main(String[] args) {

        System.out.println(reverse(0));
    }


    public static int reverse(int x) {
        StringBuilder builder = new StringBuilder(x + "");
        //是否为负数

        //尾数是否为0
        if (x != 0 && x % 10 == 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        if (x < 0) {
            builder.deleteCharAt(0);
            builder.append("-");
        }
        builder.reverse();

        Integer integer = null;
        try {
            integer = new Integer(builder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return integer;
    }


    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MAX_VALUE && pop < -8)) {
                return 0;
            }

            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

}
