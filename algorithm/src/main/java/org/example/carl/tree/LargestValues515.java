package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LargestValues515 {
    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            int len = deque.size();
            int num = Integer.MIN_VALUE;
            while (len > 0) {
                TreeNode node = deque.poll();
                num = Math.max(node.val, num);
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }

                len--;
            }
            res.add(num);

        }
        return res;
    }
}
