package org.example.ruangong.year2018;

import java.util.HashMap;
import java.util.Scanner;

public class JudgeFactor {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        final HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] * arr[j] == arr[k]) {
                        System.out.println(true);
                        return;
                    }
                }
            }
        }
        System.out.println(false);

    }
}
