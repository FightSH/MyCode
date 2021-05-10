package org.example.leetcode.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar872 {



    public static void main(String[] args) {



    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        inOrder(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        inOrder(root2, list2);
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //遍历树的子节点
    private void inOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        inOrder(root.left, list);

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        inOrder(root.right, list);

    }


}
