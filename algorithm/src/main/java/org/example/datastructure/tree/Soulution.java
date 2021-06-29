package org.example.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SH
 * @date 2021/6/29 9:59
 */
public class Soulution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList();

        inOrder(root, list);

        return list;

    }

    public void inorder(TreeNode tree, List<Integer> list) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left, list);
        list.add(tree.val);
        inOrder(tree.right, list);
    }

    public void inOrder(TreeNode tree, List<Integer> list) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left, list);
        list.add(tree.val);
        inOrder(tree.right, list);
    }


}