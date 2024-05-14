package org.example.honer;

import java.util.HashSet;
import java.util.Scanner;

public class CodeValid24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            boolean reslut = true;
            HashSet<String> hm = new HashSet();
            if (str.length() <= 8) { //长度小于8
                reslut = false;
            } else {//判断包含大小写，数字，特殊符号
                //   -1为保留尾部空元素
                if (str.split("\\d", -1).length >= 2) hm.add("number");
                if (str.split("[a-z]", -1).length >= 2) hm.add("lower");
                if (str.split("[A-Z]", -1).length >= 2) hm.add("Upper");
                if (str.split("[\\W_]", -1).length >= 2) hm.add("ha?");
            }
            if (hm.size() < 3) {//少于三种
                reslut = false;
            }
            //判断是否有重复字符串
            for (int i = 0; i <= str.length() - 3; i++) {
                String string = str.substring(i, i + 3);
                if (str.substring(i + 1).contains(string)) {
                    reslut = false;
                }
            }
            if (reslut) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
