package org.example.honer;

import java.util.PriorityQueue;
import java.util.Scanner;
// 分金条。本质是哈夫曼数
public class SplitGold3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arr[] = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res = splitGold(arr);
        System.out.println(res);

    }

    private static int splitGold(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            queue.add(sum);
        }
        return res;
    }
}
