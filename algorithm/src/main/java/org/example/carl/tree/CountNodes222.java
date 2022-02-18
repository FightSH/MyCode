package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

public class CountNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int num = 1 + leftNum + rightNum;
        return num;

    }


}
