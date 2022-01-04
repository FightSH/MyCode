package org.example.carl.linkedlist;

public class MyLinkedList {
    int val;
    MyLinkedList next;
    int length ;

    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index > length || index < 0) {
            return -1;
        }
        MyLinkedList node = this;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.val;
    }

    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        if (length == 0) {
            this.val = val;
            length = 1;
        } else {
            // 交换两节点位置


            MyLinkedList node = new MyLinkedList();
            node.val = val;
            node.next = this;
            length++;

        }
    }

    //
    public void addAtTail(int val) {
        MyLinkedList node = this;
        while (node.next != null) {
            node = node.next;
        }
        MyLinkedList tail = new MyLinkedList();
        tail.addAtIndex(0, val);
        node.next = tail;
        length++;
    }

    public void addAtIndex(int index, int val) {
        // 第0个节点

        MyLinkedList dumpy = new MyLinkedList();
        dumpy.next = this;
        MyLinkedList cur = dumpy;

        if (index < 0) {
            this.val = val;
        } else if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtHead(val);
        } else if (index > length) {

        } else {

            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            MyLinkedList next = cur.next;
            cur.next = node;
            node.next = next;
            length++;
        }


    }

    public void deleteAtIndex(int index) {

        if (index > length || index < 0) {

        } else {

            MyLinkedList dumpy = new MyLinkedList();
            dumpy.next = this;
            MyLinkedList cur = dumpy;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            length--;


        }
    }

    void print() {
        MyLinkedList listNode = this;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);

//        linkedList.print();
    }


}
