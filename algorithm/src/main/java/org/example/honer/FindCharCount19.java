package org.example.honer;

import java.util.Scanner;
// 计算某字符出现次数
public class FindCharCount19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String c = sc.next();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c.equalsIgnoreCase(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
