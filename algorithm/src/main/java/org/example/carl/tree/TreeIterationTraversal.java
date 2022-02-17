package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.List;
import java.util.Stack;

// 递归的实现就是：每次递归调用都会将函数的局部变量、参数值和返回地址等压入调用栈中，
//                之后递归返回时，从栈顶弹出上一次递归的各项参数，这就是递归为什么可以返回上一层位置的原因
public class TreeIterationTraversal {

    // 前序遍历是 中左右，每次先处理的都是中间节点，那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
    // 这样可以保证出栈的时候是 中左右 的顺序
    public static void preOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();// 中
            stack.pop();// 弹出
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }



}
