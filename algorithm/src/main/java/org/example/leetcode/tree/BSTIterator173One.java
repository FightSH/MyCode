package org.example.leetcode.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator173One {

    private List<Integer> data = new ArrayList<Integer>();

    private Iterator<Integer> iterator;


    public BSTIterator173One(TreeNode root) {

        inOrder(root);
        iterator = data.iterator();


    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);
        data.add(root.val);
        inOrder(root.right);

    }

    public int next() {
        return iterator.next();

    }

    public boolean hasNext() {
        return iterator.hasNext();

    }




}
