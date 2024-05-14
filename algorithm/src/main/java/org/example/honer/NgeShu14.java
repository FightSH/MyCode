package org.example.honer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

//n个数里出现次数大于等于n/2的数
// 直接排序
// 使用Map
public class NgeShu14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        int length = strs.length;
        int[] array = new int[length];
        for (int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            int temp = array[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
            if (map.get(temp) >= length / 2) {
                System.out.println(temp);
            }
        }
    }
}


