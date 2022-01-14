package org.example.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *  s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
 */
public class IsAnagram242 {

    public static void main(String[] args) {
        String s = "cat";
        String t = "tac";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {

        int[] array = new int[26];

        for (char c : s.toCharArray()) {
            array[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            array[c - 'a'] -= 1;
        }

        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


}
