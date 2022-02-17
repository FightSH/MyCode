package org.example.carl.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        // 队列长度
        int len = nums.length - k + 1;

        int[] res = new int[len];
        MyQueue queue = new MyQueue();
        int num = 0;

        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        res[num++] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            // 移除最前面的元素，移除是判断该元素是否放入队列
            queue.poll(nums[i - k]);
            queue.push(nums[i]);
            res[num++] = queue.peek();
        }

        return res;
    }

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        // 添加元素时，如果要添加的元素大于入口处的元素，将入口元素弹出
        // 保证队列元素单调递减
        //
        void push(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        // 这样队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }

    }

}
