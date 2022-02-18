package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.Stack;

public class InvertTree226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return root;
    }

//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }

}
