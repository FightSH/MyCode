package org.example.carl.tree;

import java.util.LinkedList;

public class Connect116 {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> deque = new LinkedList<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            int len = deque.size();

            for (int i = len; i > 0; i--) {
                Node node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

                if (i != 1) {
                    node.next = deque.peek();
                }
            }
        }

        return root;
    }

    static  class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
