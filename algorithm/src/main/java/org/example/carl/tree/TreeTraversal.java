package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.List;

/**
 * 写递归时，需要按照下面三要素去写
 * 1. 确定递归函数的参数和返回值：确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数，
 * 并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
 * 2. 确定终止条件
 * 3. 确定单层递归的逻辑
 */
public class TreeTraversal {

    // 前序遍历 中左右
    public static void preOrder(TreeNode node, List<Integer> list) {
        // 终止条件
        if (node == null) {
            return;
        }
        list.add(node.val);
        System.out.println(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }

    // 中序遍历 左中右
    public static void inOrder(TreeNode node, List<Integer> list) {
        // 终止条件
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        System.out.println(node.val);
        inOrder(node.right, list);

    }

    // 后序遍历 左右中
    public static void postOrder(TreeNode node, List<Integer> list) {
        // 终止条件
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
        System.out.println(node.val);

    }


}
