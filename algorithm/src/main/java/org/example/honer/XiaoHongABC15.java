package org.example.honer;

import java.util.Scanner;

// if(line.charAt(i)==line.c)
public class XiaoHongABC15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int length = line.length();
        System.out.println(getAnswer(line, length));
    }

    private static int getAnswer(String line, int length) {
        if (line.charAt(0) == line.charAt(1)) {
            return 2;
        }
        int result = -1;
        if (length >= 3) {
            for (int i = 2; i < length; i++) {
                if (line.charAt(i) == line.charAt(i - 1)) {
                    result = 2;
                    return result;
                }
                if (line.charAt(i) == line.charAt(i - 2)) {
                    result = 3;
                }
            }
        }
        return result;
    }
}
