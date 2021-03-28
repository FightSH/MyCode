package org.example.leetcode.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator173Two {

    private Deque<TreeNode> deque = new ArrayDeque<>();


    public BSTIterator173Two(TreeNode root) {
        while (root!= null) {
            deque.addLast(root);
            root = root.left;
        }

    }

    public int next() {
        TreeNode pop = deque.pollLast();
        int val = pop.val;
        if (pop.right != null) {
            pop = pop.right;
            while (pop != null) {
                deque.addLast(pop);
                pop = pop.left;
            }
        }

        return val;

    }

    public boolean hasNext() {
        return !deque.isEmpty();

    }

}
