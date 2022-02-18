package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.LinkedList;

public class MinDepth111 {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            depth++;
            while (len > 0) {

                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                len--;
            }
        }

        return depth;
    }
}
