package org.example.honer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 给一个数组arr，其中只有一个数出现了奇数次，其它数出现了偶数次，打印这个数
public class FindQiShu2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int arr[] = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
//
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            e = e ^ arr[i];
        }

        System.out.print(e);
    }
}
