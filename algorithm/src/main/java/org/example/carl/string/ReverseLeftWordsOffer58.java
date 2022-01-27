package org.example.carl.string;

public class ReverseLeftWordsOffer58 {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",2));

    }

    /**
     * reverse方法适合C++
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
//        StringBuilder sb = new StringBuilder(s);
//        reverse(sb, 0, n - 1);
//        reverse(sb, n, sb.length() - 1);
//        reverse(sb, 0, sb.length() - 1);
//
//        return sb.toString();

        return s.substring(n, s.length()) + s.substring(0, n);

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
