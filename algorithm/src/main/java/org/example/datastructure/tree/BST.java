package org.example.datastructure.tree;

/**
 * 基于二叉查找树的符号表
 * @author SH
 *
 */
public class BST<Key extends Comparable<Key>,Value> {

    //根节点
    private Node root;

    private class Node{
        //键
        private Key key;
        //值
        private Value value;
        //指向子树的链接
        private Node left, right;
        //以该节点为根的子树中的节点总数
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }


    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }else {
            return node.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);

    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        }else {
            return node.value;
        }
    }

    public void put(Key key,Value val) {
        //查找key，找到则更新值，否则创建新的节点
        root = put(root,key,val);

    }

    private Node put(Node node, Key key, Value val) {
        //如果key存在于以x为根节点的子树则更新他的值
        //否则将以key和val为键值对的新结点插入到该子树中
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
             put(node.left, key, val);
        } else if (cmp > 0) {
             put(node.right, key, val);
        }else {
             node.value = val;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;

    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if (t == null) {
            return node;
        }
        else {
            return t;
        }
    }


    //删除最小元素
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        }else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

}
