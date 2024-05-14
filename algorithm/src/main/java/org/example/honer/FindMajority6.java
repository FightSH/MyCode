package org.example.honer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 给定一个整型数组arr，再给定一个整数k，打印所有出现次数大于n/k的数，如果没有这样的数,请打印”-1“。
public class FindMajority6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else {
                map.put(key, 1);
            }
        }

        boolean isPrint = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > n / k) {
                isPrint = true;
                System.out.print(entry.getKey()+" ");
            }
        }

        if (!isPrint) {
            System.out.print(-1);
        }

    }
}
