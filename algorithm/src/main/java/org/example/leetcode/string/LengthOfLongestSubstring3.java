package org.example.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题主要用到思路是：滑动窗口
 * <p>
 * 什么是滑动窗口？
 * <p>
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 * <p>
 * 如何移动？
 * <p>
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * <p>
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 */
public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0, left = 0;//最大不重复子串长度，滑动窗口左指针
        for (int i = 0; i < s.length(); i++) {
            /**
             * 首先判断当前字符是否包含在map中，如果不包含，将该字符放入map，value为字符下标
             * 如果当前字符在map中存在，又有一下两种情况
             * 1.如果当前字符包含在当前有效的字段内，如abca，当遍历到第二个a时，当前有效最长子段是abc，又遍历到a，此时更新
             * left为 map.get(a)+1=1.当前有效字段更新为bca；
             * 2.当前字符不包含在当前最长有效子段内，如abba，先添加a，b进入map。此时left为0，再添加b，发现map中包含b，
             * 并且b包含在最长有效子段中——就是1）的情况。更新left=map.get(b)+1=2,此时子段更新为b，而且map中仍然包含a
             * 随后，遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，
             * 实际上，left此时应该不变，left始终为2，子段变成 ba才对。
             *
             * 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             * 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             * 因此此时新的 s.charAt(i) 已经进入到当前最长的子段中！
             */
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            // 不管是否更新left，都要更新 s.charAt(i) 的位置！
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);

        }


        return max;
    }
}
