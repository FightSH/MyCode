package org.example.carl.stackandqueue;

import java.util.Stack;

// '('，')'，'{'，'}'，'['，']'
public class IsValid20 {
    // 栈适合对称性问题
    // 括号需要考虑几种情况
    // 1.左括号多余
    // 2.右括号多余
    // 3.匹配过程中，栈空了
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '{') {
                stack.push('}');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.peek() != chars[i]) {
                return false;
            }else {
                stack.pop();
            }
        }


        return stack.empty();
    }

}
