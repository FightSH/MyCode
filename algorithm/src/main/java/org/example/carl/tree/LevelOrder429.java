package org.example.carl.tree;


import java.util.*;

public class LevelOrder429 {
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<Node> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int len = deque.size();
            ArrayList<Integer> itemList = new ArrayList<>();
            while (len > 0) {
                Node node = deque.poll();
                itemList.add(node.val);
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i)!=null) {
                        deque.offer(node.children.get(i));
                    }
                }

                len--;
            }
            res.add(itemList);
        }

        return res;
    }
    
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
}
