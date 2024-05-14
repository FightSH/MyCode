package org.example.honer;

import java.util.Scanner;

public class SanYuanZu19 {

    // 循环遍历前n-2个数作为数字一，每次对剩余数组从两端进行判断二元组，固定一个数a，目标变成了k-a，双标志向中间靠近，该题的三元组隐含了前两数不能相同。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;
            int middleValue = k - arr[i];
            while (left < right) {
                if (arr[left] + arr[right] < middleValue) {
                    left++;
                } else if (arr[left] + arr[right] > middleValue) {
                    right--;
                } else {
                    if (arr[left] == 0 || arr[left] != arr[left - 1] && arr[left] != arr[right]) {
                        System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    }
                    left++;
                    right--;
                }
            }
        }
    }

}

