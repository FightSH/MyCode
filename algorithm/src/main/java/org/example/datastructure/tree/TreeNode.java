package org.example.datastructure.tree;

import java.util.Stack;

public class TreeNode {

    public TreeNode left;

    public TreeNode right;

    public int val;

    //以该节点为根的子树中的节点总数
    private int N;

    public TreeNode(int x) {
        val = x;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //前序遍历 根节点——>左子树——>右子树
    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.val);
        preOrder(tree.left);
        preOrder(tree.right);
    }

    public static void preOrderWithNoRecursion(TreeNode tree) {
        if (tree == null) {
            return;
        }

        final Stack<TreeNode> stack = new Stack<>();

        stack.push(tree);
        while (!stack.isEmpty()) {
            final TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }


    }

    //中序遍历 左子树——>根节点——>右子树
    public static void inOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        System.out.println(tree.val);
        inOrder(tree.right);
    }

    public static void inOrderWithNoRecursion(TreeNode tree) {

        final Stack<TreeNode> stack = new Stack<>();

        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                final TreeNode pop = stack.pop();
                System.out.println(pop.val);
                tree = pop.right;
            }

        }


    }

    //后序遍历 左子树——>右子树——>根节点
    public static void postOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.val);

    }

    public static void postOrderWithNoRecursion(TreeNode tree) {
        final Stack<TreeNode> stack = new Stack<>();

        TreeNode treeNode = tree;
        TreeNode lastVisit = null;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();

                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val + " ");
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }


    }
}
