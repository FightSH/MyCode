package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.LinkedList;

/**
 * 迭代法求层数
 * 递归法 可使用前序遍历（中左右），也可以使用后序遍历（左右中），使用前序求的就是深度，使用后序求的是高度。
 * 根节点的高度就是二叉树的最大深度
 */
public class MaxDepth104 {

    /**
     * 后序遍历求树深度
     *
     * @param root
     * @return
     */
    public int postOrderCalDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别求左右两个子树的高度
        // 取左右深度最大的数值 再+1 （加1是因为算上当前中间节点）就是目前节点为根节点的树的深度。
        int leftDepth = postOrderCalDepth(root.left);
        int rightDepth = postOrderCalDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }


    int res;

    public int maxDepthByPreOrder(TreeNode root) {
        res = 0;
        if (root == null) return 0;
        preOrderCalDepth(root, 1);
        return res;
    }

    public void preOrderCalDepth(TreeNode node, int depth) {
        res = Math.max(depth, res);
        if (node.left != null && node.right != null) {
            return;
        }
        if (node.left != null) { // 左
            depth++; // 深度+1
            preOrderCalDepth(node.left, depth);
            depth--; // 回溯，深度-1
        }
        if (node.right != null) { // 右
            depth++; // 深度+1
            preOrderCalDepth(node.right, depth);
            depth--; // 回溯，深度-1
        }

    }


    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            while (len > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (len == 1) {
                    depth++;
                }
            }
        }
        return depth;
    }
}
