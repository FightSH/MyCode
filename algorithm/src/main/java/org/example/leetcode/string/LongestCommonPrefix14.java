package org.example.leetcode.string;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        final String s = longestCommonPrefix(strs);
        System.out.println(s);

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(str)) {
                final int i1 =  str.length() - 1;
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
