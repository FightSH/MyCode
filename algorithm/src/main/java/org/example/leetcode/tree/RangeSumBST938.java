package org.example.leetcode.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST938 {

    //二叉搜索树是有序的，遍历取值即可

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right   , low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }

    //
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                queue.offer(node.left);
            } else if (node.val < low) {
                queue.offer(node.right);
            }else {
                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }

        }


        return sum;
    }
}
