package org.example.honer;

import java.util.Scanner;
// https://www.nowcoder.com/practice/2c6a0a8e1d20492f92941400036e0890
public class MinStrDis22 {
    public static int process(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int last1 = -1, last2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = last2 == -1 ? min : Math.min(min, i - last2);
                last1 = i;
            } else if (strs[i].equals(str2)) {
                min = last1 == -1 ? min : Math.min(min, i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();
        String[] strs = new String[n];
        for (int i = 0; i < n; i ++) {
            strs[i] = sc.next();
        }
        sc.close();
        int res = process(strs, str1, str2);
        System.out.println(res);
    }
}
