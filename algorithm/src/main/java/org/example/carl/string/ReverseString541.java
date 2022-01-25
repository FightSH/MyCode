package org.example.carl.string;

import java.util.Arrays;

public class ReverseString541 {


    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(reverseStr(a, 2));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += (2 * k)) {
            if (i + k < chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            reverse(chars, i, chars.length - 1);
        }

        return new String(chars);
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
