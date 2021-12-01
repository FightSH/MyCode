package org.example.leetcode.string;

public class MaxPower1446 {


    public static void main(String[] args) {
        System.out.println(firstMaxPower("hooraaaaaaaaaaay"));
    }

    public static int firstMaxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        int temp = 1;

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    temp++;
                } else {
                    temp = 1;
                }
            }

            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static int secondMaxPower(String s) {
        int max = 1, temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }
        return max;
    }


}
