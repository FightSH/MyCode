package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

/**
 * 对称二叉树实际要比较的是根节点的两颗子树是否对称(即两个子树的里侧和外侧的元素是否相等)
 * 需要遍历两颗子树并比较里侧和外侧节点，  左子树左右中  右子树右左中
 */
public class IsSymmetric101 {
    // 递归法
    public boolean compare(TreeNode right, TreeNode left) {
        // 节点为空的情况
        if (right == null && left == null) {
            return true;
        } else if (right != null && left == null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        } else if (right.val != left.val) {
            return false;
        }

        boolean outside = compare(right.right, left.left); // 右子树：右     左子树：左
        boolean inside = compare(right.left, left.right); // 右子树：左     左子树：右
        boolean isSame = outside && inside;
        return isSame;


    }
//    public boolean isSymmetric(TreeNode root) {
////        return compare(root.right, root.left);
//        // 迭代法
//
//    }
}
