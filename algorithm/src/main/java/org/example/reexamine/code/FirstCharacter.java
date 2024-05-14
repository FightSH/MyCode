package org.example.reexamine.code;

import java.util.Scanner;

// 第一个只出现一次的字符
public class FirstCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (line.indexOf(aChar) == line.lastIndexOf(aChar)) {
                System.out.print(aChar);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.print(-1);
        }

    }

}
