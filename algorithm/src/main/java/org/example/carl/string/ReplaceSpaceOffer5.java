package org.example.carl.string;

import java.util.Locale;

public class ReplaceSpaceOffer5 {


    public static void main(String[] args) {
        String a = "We are happy.";
        System.out.println(replaceString(a));
    }

    public static String replaceString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }

        }
        return sb.toString();
    }

    /**
     *
     * 双指针法，由后向前填充新数组
     * @param s
     * @return
     */
    public static String replaceStringDoublePoint(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        if (sb.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s = s + sb.toString();
        int right = s.length() - 1;

        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else {
                chars[right] = chars[left];
            }
            right--;
            left--;
        }
        return new String(chars);
    }

}
