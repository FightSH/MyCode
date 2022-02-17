package org.example.carl.tree;

import org.example.datastructure.tree.TreeNode;

import java.util.Collections;
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

    // 中序遍历和前序遍历代码不通用,因为前序遍历的顺序是中左右，先访问的元素是中间节点，要处理的元素也是中间节点
    // 其要访问的元素和要处理的元素顺序是一致的，都是中间节点。
    // 中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部
    // 再开始处理节点（也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
    // 因此需要借助指针遍历帮助访问节点，栈来处理节点上的元素
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { // 将指针访问至最底层
                stack.push(cur); // 将访问节点放入栈
                cur = cur.left; // 像左访问
            } else { // 访问到底部。可以处理节点
                cur = stack.pop(); // 弹出的节点就是要处理的数据
                list.add(cur.val); // 中
                cur = cur.right; // 右
            }
        }

    }
    // 后序遍历 左右中，调整前序遍历代码即可
    // 前序遍历 中左右  调整入栈顺序可得 中右左  再反转result数组 即 左右中
    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();// 中
            stack.pop();// 弹出
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
    }
}
