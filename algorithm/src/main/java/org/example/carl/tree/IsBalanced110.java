package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

/**
 * 高度平衡二叉树定义：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 * 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数。
 * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。
 */
public class IsBalanced110 {
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;



    }

    static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == -1) {
            return -1;
        }
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
