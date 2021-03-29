package org.example.leetcode.bitwise;

import java.util.Arrays;

public class ReverseBits190 {

    public static void main(String[] args) {
        System.out.println(reverseBitsTwo(43261596));
    }

    public static int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int a = 32;
        int length = s.length();
        a = a - length;
        StringBuilder builder = new StringBuilder(s).reverse();
        for (int i = 0; i < a; i++) {
            builder.append(0);
        }

        return Integer.parseUnsignedInt(builder.toString(), 2);

    }

    public static int reverseBitsTwo(int n) {
        byte[] bytes = new byte[32];
        int count = 0;
        while (n / 2 != 1) {
            bytes[count] = (byte) (n % 2);
            n = n / 2;
            count++;
        }
        bytes[count + 1] = 1;
        System.out.println(Arrays.toString(bytes));
        count = 31;
        n = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 1) {
                n += Math.pow(2, count);
            }
            count--;
        }

//        for (int i = bytes.length - 1; i > 0; i--) {
//            count += Math(2)
//        }

//
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < bytes.length; i++) {
//            s.append(bytes[i]);
//        }
//        System.out.println(s);
//        System.out.println(Arrays.toString(bytes));
        return n;
    }
}
