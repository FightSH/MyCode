package org.example.ruangong.year2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicateChar {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb.toString());

    }
}
