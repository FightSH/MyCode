package org.example.ruangong;

public class BitConform {
    public static void main(String[] args) {

        int num = 456;
        final StringBuilder sb = new StringBuilder("");
        while (num != 0) {
            sb.insert(0, num % 2);
            num = num / 2;
        }
        final String res = sb.toString();
        System.out.println(res);
    }
}
