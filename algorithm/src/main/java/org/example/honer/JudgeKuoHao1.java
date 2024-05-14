package org.example.honer;

import java.util.Scanner;
import java.util.Stack;

// 给定一个括号字符串str，返回最长的能够完全正确匹配括号字符字串的长度。
public class JudgeKuoHao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Integer> stack = new Stack();
        int maxans = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        System.out.println(maxans);
    }
}
