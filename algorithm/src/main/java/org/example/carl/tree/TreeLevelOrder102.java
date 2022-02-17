package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历一个二叉树。就是从左到右一层一层的去遍历二叉树。借用一个辅助数据结构即队列来实现，队列先进先出，符合一层一层遍历的逻辑。
 */
public class TreeLevelOrder102 {


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode itemNode = queue.poll();
                itemList.add(itemNode.val);
                if (itemNode.left != null) {
                    queue.offer(itemNode.left);
                }
                if (itemNode.right != null) {
                    queue.offer(itemNode.right);
                }
                len--;

            }
            res.add(itemList);

        }
        return res;
    }

}
