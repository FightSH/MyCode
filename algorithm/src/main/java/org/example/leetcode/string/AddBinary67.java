package org.example.leetcode.string;

public class AddBinary67 {

    public static void main(String[] args) {

        String a = "11010";
        String b = "1011";
        String binary = addBinary(a, b);
        System.out.println(binary);

    }

    public static String addBinary(String a, String b) {
        StringBuilder buffer = new StringBuilder();

        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            if (i < a.length()) {
                int index = a.length() - 1 - i;
                char c = a.charAt(index);
                carry +=  c -'0';
            }

            if (i < b.length()) {
                int index = b.length() - 1 - i;
                char c = b.charAt(index);
                carry +=  b.charAt(b.length() - 1 - i)-'0';
            }

            char ch = (char) (carry % 2 + '0');
            buffer.append(ch);
            carry /= 2;
        }

        if (carry > 0) {
            buffer.append('1');
        }
        buffer.reverse();
        return buffer.toString();


    }

}
