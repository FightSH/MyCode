package org.example.leetcode.stack;

import java.util.*;

public class EvalRPN150 {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(tokens);

    }


    public static int evalRPN(String[] tokens) {

        Stack<String> nums = new Stack<>();
        for (String token : tokens) {
            //是运算符
            if ("+-*/".contains(token)) {
                String num2 = nums.pop();
                String num1 = nums.pop();
                String ans = calc(num1, num2, token);
                nums.push(ans);
                //不是运算符
            } else {
                nums.push(token);
            }
        }
        return Integer.parseInt(nums.pop());

    }


    public static String calc(String num1, String num2, String op) {
        int ans = 0;
        if (op.equals("+")) {
            ans = Integer.parseInt(num1) + Integer.parseInt(num2);
        } else if (op.equals("-")) {
            ans = Integer.parseInt(num1) - Integer.parseInt(num2);
        } else if (op.equals("*")) {
            ans = Integer.parseInt(num1) * Integer.parseInt(num2);
        } else if (op.equals("/")) {
            ans = Integer.parseInt(num1) / Integer.parseInt(num2);
        }
        return ans + "";
    }


}
