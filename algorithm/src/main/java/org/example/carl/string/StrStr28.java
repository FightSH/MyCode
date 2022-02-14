package org.example.carl.string;

import java.util.Arrays;

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


    /**
     * https://mp.weixin.qq.com/s/Crx-usqUq0BIioUbxFSa6w
     * BF算法是从前向后进行毕竟，而BM算法是从后向前进行比较的
     * 如果发现有一个字符不匹配，那么就将主串中的这个字符称为坏字符，并在模式串中寻找是否存在此字符。
     * 若不存在只需要将模式串移动到坏字符后一位即可
     * 如果存在，那么需要将模式串中的字符和坏字符对齐，如果有多个，要让最靠右的对应元素与坏字符匹配
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrByBM(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();

        int haylen = haystack.length();
        int needlen = needle.length();

        return bm(hay, haylen, need, needlen);

    }

    private static int bm(char[] hay, int haylen, char[] need, int needlen) {
        // 创建一个数组来保存最右边字符下标
        int[] bc = new int[256];
        badChar(need, needlen, bc);

        // 用来保存各种长度好后缀的最右位置数组
        int[] suffix_index = new int[needlen];
        // 判断是否头部
        boolean[] isPre = new boolean[needlen];
        goodSuffix(need, needlen, suffix_index, isPre);
        // 第一个匹配字符
        int i = 0;

        while (i <= haylen - needlen) {
            int j;
            // 从后向前匹配，找到坏字符
            for (j = needlen - 1; j >= 0; j--) {
                if (hay[i + j] != need[j]) {
                    break;
                }
            }

            // 匹配成功
            if (j < 0) {
                return i;
            }

            // 匹配失败
            // 求出坏字符规则下移动的位数，即坏字符下标减去最右边的下标
            int x = j - bc[hay[i + j]];
            int y = 0;
            // 好后缀情况，求出好后缀情况下的移动位数，如果不含有好后缀，按照坏字符进行
            if (y < needlen - 1 && needlen - 1 - j > 0) {
                y = move(j, needlen, suffix_index, isPre);
            }
            i = i + Math.max(x, y);


        }
        return -1;

    }

    private static int move(int j, int needlen, int[] suffix_index, boolean[] isPre) {
        // 好后缀长度
        int k = needlen - 1 - j;
        // 如果含有长度为 k 的好后缀，返回移动位数
        if (suffix_index[k] != -1) {
            return needlen - suffix_index[k] + 1;
        }
        // 找头部为好后缀子串的最大长度，从长度最大的子串开始
        for (int r = j + 2; r <= needlen - 1;r++) {
            if (isPre[needlen - r]==true) {
                return r;
            }
        }

        // 没有发现好后缀匹配的串，或者头部为好后缀子串，移动到 m 位，即匹配串的长度
        return needlen;
    }

    // 求好后缀条件下的移动位数
    private static void goodSuffix(char[] need, int needlen, int[] suffix_index, boolean[] prefix) {
        for (int i = 0; i < needlen; ++i) {
            suffix_index[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < needlen - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && need[j] == need[needlen - 1 - k]) {
                --j;
                ++k;
                suffix_index[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    // 求坏字符情况下移动位数
    private static void badChar(char[] need, int needlen, int[] bc) {
        Arrays.fill(bc, -1);
        // needlen是模式串的长度，如果有两个相同的 字符，后面的下标会覆盖前面。
        for (int i = 0; i < needlen; i++) {
            int ascii = (int) need[i];
            bc[ascii] = i;
        }


    }

}
