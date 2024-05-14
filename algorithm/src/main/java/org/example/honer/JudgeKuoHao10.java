package org.example.honer;

import java.util.Scanner;
import java.util.Stack;

// 给定一个字符串str，判断是不是整体有效的括号字符串(整体有效：即存在一种括号匹配方案，使每个括号字符均能找到对应的反向括号，且字符串中不包含非括号字符)。
public class JudgeKuoHao10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                System.out.println(false);
                return;
            }
            if (str.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            } else {
                stack.push(str.charAt(i));
            }

        }
        if (stack.empty()) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");


    }
}
