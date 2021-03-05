package org.example.leetcode.stack;

import java.util.Stack;

public class MyQueue232 {

    private Stack<Integer> first;

    private Stack<Integer> second;

    /** Initialize your data structure here. */
    public MyQueue232() {
        first = new Stack();
        second = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }

        return second.pop();



    }

    /** Get the front element. */
    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }

        return second.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();

    }

    public static void main(String[] args) {
        final MyQueue232 myQueue232 = new MyQueue232();
        myQueue232.push(1);
        myQueue232.push(2);

        System.out.println(myQueue232.peek());
        System.out.println(myQueue232.pop());
    }

}
