package org.example.sort.stringsort;

/**
 * @author SH
 * @date 2021/5/2 21:45
 */
public class LSD {
    //低位优先。使用了键索引计数法
    //如果字符串长度均为W，那就从右向左以每个位置的字符作为键，用键索引计数法将字符串排序N遍
    public static void main(String[] args) {

    }

    public static void LSDSort(String[] a, int W) {
        //
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            //计算出现频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            //将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }


        }


    }

}
