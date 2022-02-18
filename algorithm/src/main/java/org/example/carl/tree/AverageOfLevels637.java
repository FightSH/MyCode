package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.*;

public class AverageOfLevels637 {

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> deque = new LinkedList<>();

        deque.offer(root);
        while (!deque.isEmpty()) {

            int len = deque.size();
            double sum = 0;
            for (int i = len; i > 0; i--) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

            res.add(sum / len);
        }

        return res;

    }


}
