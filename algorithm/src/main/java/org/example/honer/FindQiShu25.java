package org.example.honer;

import java.util.Scanner;

// 给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。
public class FindQiShu25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        int aEorb = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            aEorb ^= arr[i];
        }
        //分离：异或为1表示两者在该位上一定不同
        int diffBit = aEorb&(~aEorb+1); //提取最右边的一（其实只要是1的位都可以） 必然是一个为0一个为1
        int diffBitIs0 = 0;
        for (int i = 0; i < N; i++)
            if ((arr[i]&diffBit)==0)    //剔除不符合异位为0条件的奇数
                diffBitIs0 ^= arr[i];   //偶数还是被异或没有

        int diffBitIs1 = aEorb ^ diffBitIs0;
        if (diffBitIs0>diffBitIs1){
            int tmp = diffBitIs0;
            diffBitIs0 = diffBitIs1;
            diffBitIs1 = tmp;
        }

        System.out.println(diffBitIs0 + " " + diffBitIs1);
    }
}
