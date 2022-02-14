package org.example.carl.string;

public class StrStr28 {


    public static void main(String[] args) {
        System.out.println(strStrByBF("hello", "ll"));
    }

    public static int strStrByBF(String haystack, String needle) {

        int hayLen = haystack.length();
        int needLen = needle.length();
        if (needLen > hayLen) {
            return -1;
        }
        if (needLen == 0) {
            return 0;
        }

        for (int i = 0; i < hayLen - needLen + 1; i++) {
            int j = 0;
            for (j = 0; j < needLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // 不匹配，主串后移
                    break;
                }
            }
            // 匹配上了
            if (j == needLen) {
                return i;
            }
        }

        return -1;

    }


    public static int strStrByBF2(String haystack, String needle) {
        int hayLen = haystack.length();
        int needLen = needle.length();
        // i主串指针，j模式串指针
        int i, j;
        // 循环，只有 i 增长
        for (i = 0, j = 0; i < hayLen && j < needLen; i++) {
            // 相同，j 后移
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j;
            } else {
                // 不匹配时， 将 j 重新指向 模式串头部，将 i 匹配本次匹配开始的下一字符
                i -= j;
                j = 0;
            }
        }

        int index = j == needLen ? i - needLen : -1;
        return index;

    }


}
