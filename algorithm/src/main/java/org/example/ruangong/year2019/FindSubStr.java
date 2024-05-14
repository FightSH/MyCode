package org.example.ruangong.year2019;

import java.util.Scanner;

public class FindSubStr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String subStr = sc.next();

        int i = 0;
        int count = 0;
        while (true) {

            int index = str.indexOf(subStr, i);
            if (index != -1) {
                count++;
                i = index + 1;
            }else {
                break;
            }
        }
        System.out.println(count);
    }
}
