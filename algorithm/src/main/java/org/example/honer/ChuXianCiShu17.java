package org.example.honer;

import java.util.Scanner;
// 只出现一次的字符
public class ChuXianCiShu17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            getResult(s);
        }
        sc.close();
    }

    private static void getResult(String str) {
        //设置信号量
        int signal = 0;
        for(int i = 0; i < str.length(); i++){
            //判断每个字符是否出现第二次，如果存在，设置信号量signal为1；
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                System.out.print(str.charAt(i));
                signal = 1;
                break;
            }
        }
        if (signal == 0) {
            System.out.println(-1);
        }
    }

}
