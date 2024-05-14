package org.example.honer;

import org.example.datastructure.tree.TreeNode;

import java.util.Arrays;

//一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。(每个节点的值各不相同)
public class FindTreeWrongValue12 {
    int[] result = new int[2];
    int index = 1;
    TreeNode preNode;
    // 中序遍历
    public int[] findError(TreeNode root) {
        // write code here
        if (root == null) {
            return result;
        }
        //递归左子树
        findError(root.left);
        // pre节点，上一个访问的节点
        if (preNode == null) {
            preNode = root;
        }
        // 找交换的第一个节点
        if (index == 1 && root.val < preNode.val) {
            result[index] = preNode.val;
            index--;
        }
        //找交换的第二个节点
        if (index == 0 && root.val < preNode.val) {
            result[index] = root.val;
        }
        preNode = root;
        findError(root.right);

        return result;
    }

}
