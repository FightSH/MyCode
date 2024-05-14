package org.example.reexamine.code;

import java.util.Scanner;
import java.util.Stack;

public class KuoHao {

    //(()())
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Stack<Integer> myStack = new Stack<>();
        char[] chars = line.toCharArray();
        int result = 0;
        myStack.push(-1);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                myStack.push(i);
            } else {
                myStack.pop();
                if (myStack.empty()) {
                    myStack.push(i);
                } else {
                    result = Math.max(result, i - myStack.peek());
                }
            }
        }
        System.out.print(result);
    }
}
