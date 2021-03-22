package org.example.leetcode.bitwise;

public class HammingWeight191 {

    //位运算
    public static int hammingWeight(int n) {
//        int i = Integer.bitCount(n);

        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;



    }

}
