package org.example.honer;
// 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序

import java.util.Scanner;

/**
 * 维护三个变量,l,idx,r。左区间[0,l],中间区间[l+1,idx],右区间[idx+1,r]。
 * 初始化l=-1，r=len,idx=0。idx用来遍历数组。
 * 当arr[idx]=1,idx++;
 * 当arr[idx]=0,swap(arr[l+1,idx]),i++,idx++
 * 当arr[idx]=2,swap(arr[idx,r-1]),r--,idx++
 * 当idx=r说明中区间和右区间连上了。排序结束。
 */

public class ArrayPartition4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                a++;
            }
            if (arr[i] == 1) {
                b++;
            }
            if (arr[i] == 2) {
                c++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i < a) {
                arr[i] = 0;
            } else if (i < a + b) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        for (int elm : arr) {
            System.out.print(elm+" ");
        }
    }
    public static void sort(int[] arr) {
        if (arr.length > 1) {
            int l = -1;
            int r = arr.length;
            int idx = 0;
            while (idx != r) {
                if (arr[idx] == 1) {
                    ++idx;
                } else if (arr[idx] == 0) {
                    swap(arr, idx++, ++l);
                } else {
                    swap(arr, idx, --r);
                }
            }
        }
    }
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
