package org.example.honer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SameTree5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 构建树A
        String[] treeParams = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(treeParams[0]);
        TreeNode tree1 = new TreeNode(Integer.parseInt(treeParams[1]));
        HashMap<Integer, TreeNode> treeMap = new HashMap<>();
        treeMap.put(tree1.val, tree1);
        int i = 0;
        while (i < m) {
            treeParams = bufferedReader.readLine().split(" ");
            int val = Integer.parseInt(treeParams[0]);
            int leftVal = Integer.parseInt(treeParams[1]);
            int rightVal = Integer.parseInt(treeParams[2]);
            TreeNode node = treeMap.get(val);
            if (leftVal != 0) {
                node.left = new TreeNode(leftVal);
                treeMap.put(leftVal, node.left);
            }
            if (rightVal != 0) {
                node.right = new TreeNode(rightVal);
                treeMap.put(rightVal, node.right);
            }
            i++;
        }
        // 构建树B
        treeParams = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(treeParams[0]);
        TreeNode tree2 = new TreeNode(Integer.parseInt(treeParams[1]));
        treeMap.clear();
        treeMap.put(tree2.val, tree2);
        int j = 0;
        while (j < n) {
            treeParams = bufferedReader.readLine().split(" ");
            int val = Integer.parseInt(treeParams[0]);
            int leftVal = Integer.parseInt(treeParams[1]);
            int rightVal = Integer.parseInt(treeParams[2]);
            TreeNode node = treeMap.get(val);
            if (leftVal != 0) {
                node.left = new TreeNode(leftVal);
                treeMap.put(leftVal, node.left);
            }
            if (rightVal != 0) {
                node.right = new TreeNode(rightVal);
                treeMap.put(rightVal, node.right);
            }
            j++;
        }
        System.out.println(ifSubStructureSame(tree1, tree2));
    }

    private static boolean ifSubStructureSame(TreeNode treeA, TreeNode treeB) {
        if (treeA == null || treeB == null) return false;    // 空树不是任何一棵树的子树
        // 树A和树B完全一样，或树B为树A的左右子树之一都可以
        return isSameTree(treeA, treeB) || ifSubStructureSame(treeA.left, treeB) || ifSubStructureSame(treeA.right, treeB);
    }

    private static boolean isSameTree(TreeNode treeA, TreeNode treeB) {
        if (treeB == null) return true;     // B树到空，说明节点都检查完了，返回true
        if (treeA == null || treeA.val != treeB.val) return false;    // A树为空或节点值不同，返回false
        // 检查两棵树的左右子树是否都相同
        return isSameTree(treeA.left, treeB.left) && isSameTree(treeA.right, treeB.right);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

