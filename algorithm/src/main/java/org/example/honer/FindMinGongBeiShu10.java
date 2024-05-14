package org.example.honer;

// 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
public class FindMinGongBeiShu10 {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        System.out.println(solution(a, b));
        System.out.println(solution2(a, b));

    }

    private static int solution2(int a, int b) {
        // 最小公倍数 = 两个数相乘/最大公约数
        int m = Math.min(a, b);
        int n = Math.max(a, b);

        int x = n % m;
        while (x != 0) {
            n = m;
            m = x;
            x = n % m;
        }
        return a * b / m;
    }

    private static int solution(int a, int b) {

        // 或者设k为最小公倍数，则有 k/a=i,k/b=j 即（a*i）%b==0
        int i = Math.min(a, b);
        while ((a * i) % b != 0) {
            i++;
        }
        return a * i;
    }
}
