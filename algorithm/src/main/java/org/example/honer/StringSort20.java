package org.example.honer;

import java.util.Arrays;
import java.util.Scanner;

// 给定 n 个字符串，请对 n 个字符串按照字典序排列。
public class StringSort20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = Integer.parseInt(in.nextLine());
            String[] array = new String[num];
            for (int i = 0; i < num; i++) {
                String next = in.nextLine();
                array[i] = next;
            }
            Arrays.stream(array).sorted().forEach(System.out::println);
        }
    }
}
