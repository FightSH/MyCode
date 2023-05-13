package org.example.carl.hashtable;

public class IsAnagram242 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] hashChars = new int[26];
            for (char c : s.toCharArray()) {
                hashChars[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                hashChars[c - 'a']--;
            }

            for (int hashChar : hashChars) {
                if (hashChar != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
