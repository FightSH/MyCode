package org.example.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// 交换两个字母使得字符串相等
public class BuddyStrings859 {


    public static void main(String[] args) {

        System.out.println(buddyStrings("aaabc", "aaabd"));

    }

    public static boolean buddyStrings(String s, String goal) {


        // 如果两字符串长度不相等，直接false
        if (s.length() != goal.length()) {
            return false;
        }
        // 如果两字符串长度相等

        // 一、如果两字符串相等，那么如果存在两个重复元素，那么为true
        if (s.equals(goal)) {

            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            return set.size() < s.length();

        }


        // 二、如果两字符串不相等，那么需要两个字符串有两个地方不同，否则为false
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index++;
                map.put(index, i);
                if (index == 2) {
                    break;
                }
            }
        }
        if (index != 2) {
            return false;
        }
        int first = map.get(1);
        int second = map.get(2);
        char[] chars = s.toCharArray();
        char aChar = chars[first];
        char bChar = chars[second];
        chars[first] = bChar;
        chars[second] = aChar;

        String snew = new String(chars);
        return snew.equals(goal);

//        if (index == 2 && map.size() == 2) {
//            return true;
//        }

    }


}
