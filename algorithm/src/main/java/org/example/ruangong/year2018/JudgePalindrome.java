package org.example.ruangong.year2018;

public class JudgePalindrome {
    public static void main(String[] args) {

        int num = 1000001;
        String str = num + "";

        char[] chars = str.toCharArray();
        for (int i = 0; i <= chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                System.out.println(false);
                return;
            }

        }
        System.out.println(true);
    }
}
