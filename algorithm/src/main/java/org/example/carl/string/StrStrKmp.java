package org.example.carl.string;

public class StrStrKmp {

    public static int strStr(String haystack, String needle) {

        int hayLen = haystack.length();
        int needLen = needle.length();
        if (hayLen == 0) {
            return -1;
        }
        if (needLen == 0) {
            return 0;
        }

        char[] hasyarr = haystack.toCharArray();
        char[] nearr = needle.toCharArray();

        return kmp(hasyarr, hayLen, nearr, needLen);

    }

    private static int kmp(char[] hasyarr, int hayLen, char[] nearr, int needLen) {
        // 获取next数组
        int[] next = next(nearr, needLen);
        int j = 0;
        for (int i = 0; i < hayLen; i++) {
            // 发现不匹配字符，然后根据 next 数组移动指针，移动到最大公共前后缀的前缀的后一位
            while (j > 0 && hasyarr[i] != nearr[j]) {
                j = next[j - 1] + 1;
                // 超出长度时，可直接返回不存在
                if (needLen - j + i > hayLen) {
                    return -1;
                }
            }
            // 如果相同就将指针同时后移一下，比较下个字符
            if (hasyarr[i] == nearr[j]) {
                j++;
            }
            // 遍历整个模式串，返回模式串的起点下标
            if (j == needLen) {
                return i - needLen + 1;
            }
        }
        return -1;
    }

    private static int[] next(char[] nearr, int needLen) {
        int[] next = new int[needLen];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < needLen; i++) {
            // 此时可知 [0,i-1] 的最长前后缀，但是k+1指向的值和i不相同时，需要回溯
            // 因为 next[K] 是用来记录子串的最长公共前后缀的尾坐标（即长度）
            // 因此要找 k+1 前一个元素在 next 数组里的值，即next[k+1]
            while (k != -1 && nearr[k + 1] != nearr[i]) {
                k = next[k];
            }
            // 相同情况下，就是k的下一位和i相同时，此时知道了[0,i-1]的最长前后缀
            // 然后 k-1 又和 i 相同，最长前后缀加1，即可
            if (nearr[k + 1] == nearr[i]) {
                k++;
            }
            next[i] = k;
        }

        return next;
    }

}
