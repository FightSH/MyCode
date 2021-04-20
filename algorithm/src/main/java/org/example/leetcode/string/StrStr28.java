package org.example.leetcode.string;

public class StrStr28 {

    public static void main(String[] args) {
//        "mississippi"
//"issipi"
        System.out.println(strStr("mississippi", "issipi"));
    }


    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            //找到起始点
            if (haystack.charAt(i) != first) {
                while (++i < haystack.length() && haystack.charAt(i) != first) ;
            }

            //判断是否存在
            if (i < haystack.length()) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                if (end > haystack.length()) {
                    return -1;
                }
                for (int k = 1;
                     j < end && haystack.charAt(j) == (needle.charAt(k));
                     j++, k++)
                    ;
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }


        return -1;

    }

}
