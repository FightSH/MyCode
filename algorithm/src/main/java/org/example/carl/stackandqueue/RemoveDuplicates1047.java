package org.example.carl.stackandqueue;

import java.util.Stack;

public class RemoveDuplicates1047 {
    public static void main(String[] args) {
        System.out.printf(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.empty()) {
                stack.push(chars[i]);
            } else if (stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }
}
