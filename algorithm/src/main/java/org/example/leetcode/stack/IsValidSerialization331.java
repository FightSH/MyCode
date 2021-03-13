package org.example.leetcode.stack;

import java.util.Stack;

public class IsValidSerialization331 {

    public static void main(String[] args) {
//        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String str = "9,#,92,#,#";

        System.out.println(isValidSerialization(str));


    }

    public static boolean isValidSerialization(String preorder) {

        final Stack<String> stack = new Stack<>();

        final String[] split = preorder.split(",");

        for (int i = 0; i < split.length; i++) {

            stack.push(split[i]);

            while (stack.size() >= 3) {
                final String pop = stack.pop();
                final String pop1 = stack.pop();
                final String pop2 = stack.pop();
                if (pop.equals("#") && pop1.equals("#") && !pop2.equals("#")) {
                    stack.push("#");
                } else {
                    stack.push(pop2);
                    stack.push(pop1);
                    stack.push(pop);
                    break;
                }
            }
        }

        return stack.peek().equals("#") && stack.size() == 1;

    }
}
