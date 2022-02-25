package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;

    }

    static void traversal(TreeNode cur, List<Integer> path, List<String> result) {

        path.add(cur.val);

        // 说明找到叶子节点
        // 下面为终止除了逻辑
        if (cur.right == null && cur.left == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));// 记录最后一个节点
            result.add(sb.toString());
            return;
        }

        // 单层递归处理逻辑
        // 前序遍历，先处理中间节点
        // 递归完之后，需要回溯，因为 path 需要删节点

        if (cur.left != null) {
            traversal(cur.left, path, result);
            path.remove(path.size() - 1);
        }
        if (cur.right != null) {
            traversal(cur.right, path, result);
            path.remove(path.size() - 1);
        }
        // 回溯与递归是一一对应的，有一个递归就要有一个回溯

    }

}
