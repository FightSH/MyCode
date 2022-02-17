package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeUnityIterationTraversal {

    // 中左右   插入顺序  右左中
    public static List preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            // 栈当前节点
            TreeNode node = stack.peek();
            if (node != null) {
                // 弹出之前的节点后，再次重新按照反顺序添加节点到栈中
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node); // 中节点，加入空节点进行标记，
                stack.push(null);

            } else {
                // 为空节点，说明空节点后的节点是要处理的节点
                stack.pop(); // 弹出空
                node = stack.pop(); // 取出要处理的元素
                list.add(node.val);
            }
        }

        return list;
    }

}
