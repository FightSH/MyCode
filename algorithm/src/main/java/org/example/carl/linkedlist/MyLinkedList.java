package org.example.carl.linkedlist;

import java.util.LinkedList;

public class MyLinkedList {
    int length = 0;

    Node first;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index < 0 || index > length - 1) {
            return -1;
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;

    }

    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (length != 0) {
            node.next = first;
        }
        first = node;

        length++;
    }

    //
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.val = val;
        if (length == 0) {
            first = node;
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length ) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node cur = first;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node temp = cur.next;
            cur.next = node;
            node.next = temp;

            length++;
        }


    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > length - 1) {
            return;
        }
        length--;
        if (index == 0) {
            first = first.next;

            return;
        }


        Node cur = first;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;


    }

    void print() {
        Node node = this.first;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);

        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);

//        linkedList.print();
    }


}
