package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.*;

public class RightSideView199 {
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> deque = new LinkedList<>();

        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();

            while (len > 0) {
                TreeNode node = deque.poll();
                if (len == 1) {
                    // 说明是此层最后一个节点
                    res.add(node.val);
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

        return res;


    }
}
