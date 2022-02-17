package org.example.carl.string;

import java.util.Arrays;

// https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
public class StrStr {

    public static void main(String[] args) {
        String needle = "aabaaf";
        int[] next = getNext(needle.length(), needle.toCharArray());
        System.out.println(Arrays.toString(next));
    }

    /**
     *  构造 next 数组就是计算模式串 s 前缀表的过程
     *  一般主要由以下三步
     *  1. 初始化
     *  2. 处理前后缀不相同的情况
     *  3. 处理前后缀相同的情况
     * 前缀是指不包含最后一个字符的所有以第一个字符开头的连续子串；后缀是指不包含第一个字符的所有以最后一个字符结尾的连续子串。
     * @param needleLen
     * @return
     */
    public static int[] getNext(int needleLen,char[] needle) {
        // 初始化
        int[] next = new int[needleLen];
        // 定义两个指针 i 和 j。 j指向前缀起始位置，i指向后缀起始位置
        int j = -1; // 初始化为-1。因为 前缀表统一减一是其中的一种实现，也可以不进行-1
        next[0] = j; // next[i] 表示 i 之前最长相等的前后缀长度，所以此处是 j

        // 处理前后缀不相同的情况
        // j初始化为-1，那么 i 从 1开始，进行 s[i] 与 s[j+1] 的比较
        for (int i = 1; i < needleLen; i++) {
            // 如果 s[i] 与 s[j+1] 不相同，即 前后缀末尾不相同，此时需要向前回退
            // 如何回退？ next[j]就是记录着j（包括j）之前的子串的相同前后缀的长度。
            // s[i] 与 s[j+1] 不相同，就要找 j+1 前一个元素在next数组里的值(就是next[j])
            while (j >= 0 && needle[i] != needle[j + 1]) {
                j = next[j];
            }

            // 处理前后缀相同的情况
            // 如果 s[i] 与 s[j + 1] 相同，那么就同时向后移动i 和j 说明找到了相同的前后缀
            // 同时还要将j（前缀的长度）赋给next[i], 因为next[i]要记录相同前后缀的长度。
            if (needle[i] == needle[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
