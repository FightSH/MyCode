package org.example.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
    }
    // 针对字母等有限位，可以考虑使用数组替代map
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }

            }
        }
        return map.size() == 0;


    }

    public static boolean canConstructTwo(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (char c : magazine.toCharArray()) {
            record[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
            if (record[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
