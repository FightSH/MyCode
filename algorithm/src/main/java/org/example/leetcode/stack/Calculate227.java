package org.example.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Calculate227 {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};


    public static void main(String[] args) {
        String s = " (50*9)/5+29*64/8+(20+30) +105*252*3+560";
        int result = calculate(s);
        System.out.println(result);

    }

    //
    private static int calculate(String s) {
        s = s.replaceAll(" ", "");

        s = s.replaceAll("\\(-", "(0-");


        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        nums.addLast(0);
        final char[] chars = s.toCharArray();
        final int length = chars.length;

        for (int i = 0; i < length; i++) {

            final char ch = chars[i];
            if (ch == '(') {
                ops.addLast(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(ch)) {
                    int u = 0;
                    int j = i;
                    //将从i位置开始后面的连续数字整体取出，加入nums
                    while (j < length && isNumber(chars[j])) {
                        u = u * 10 + (chars[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(ch)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(ch);
                }
            }


        }
        while (!ops.isEmpty() && ops.peekLast() != '(') {
            calc(nums, ops);
        }
        return nums.peekLast();

    }


    public static void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int) Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.addLast(ans);
    }

    public static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
