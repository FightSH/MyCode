package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

/**
 * 注意，是左叶子节点
 */
public class SumOfLeftLeaves404 {
    public static void main(String[] args) {

    }


    public static int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;
        return calLeft(root, sum);
    }

    public static int calLeft(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }

        // 为何只能后序遍历
        // 前序遍历结果为 1545
        // 中序遍历结果为 309

        sum += calLeft(node.left, sum);
        sum += calLeft(node.right, sum);
        // 求左叶子节点而不是左节点
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        return sum;
    }
}
