package org.example.carl.string;

import java.util.Arrays;

public class ReverseString344 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        reverseString(chars);

        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;

        }


    }
}
