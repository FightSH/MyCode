package org.example.carl.string;

public class ReverseWords151 {
    public static void main(String[] args) {
        String a = "  hello world!  ";
        System.out.println(reverseWords(a));
    }

    public static String reverseWords(String s) {

        StringBuilder sb = removeSpace(s);

        reverse(sb, 0, sb.length() - 1);

        int left = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                reverse(sb, left, i - 1);
                left = i + 1;
            }
        }

        reverse(sb, left, sb.length() - 1);

        return sb.toString();
    }

    public static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 过滤开头的 space
        while (s.charAt(start) == ' ') {
            start++;
        }
        // 过滤结尾的 space
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;


    }

    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }


}
