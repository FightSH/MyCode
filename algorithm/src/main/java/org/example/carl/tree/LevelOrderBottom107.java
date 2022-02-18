package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            ArrayList<Integer> itemList = new ArrayList<>();

            for (int i = len; i > 0; i--) {
                TreeNode node = deque.pop();

                itemList.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

            }
            res.add(itemList);

        }

        Collections.reverse(res);
        return res;

    }


}
