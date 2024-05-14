package org.example.ruangong.year2018;

import java.util.Scanner;

public class FindContinueStr {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();


        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] + 1 == chars[i + 1] && chars[i] + 2 == chars[i + 2]) {
                System.out.print(chars[i]);
                System.out.print(chars[i + 1]);
                System.out.print(chars[i + 2]);
                System.out.println("");
            }
        }


    }
}
