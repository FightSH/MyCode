package org.example.leetcode.linkedlist;

import java.math.BigDecimal;

public class RotateRight61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        ListNode node = rotateRight(listNode, 4);

        node.print(node);



    }
    //评价 思路基本正确。但仍可以优化
    public static ListNode rotateRight(ListNode head, int k) {
        //判断 k 的大小和head的长度
        //对k%head。
        //从后向前得到链表，将链表位置接到头链表上
        if (head == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        //再次遍历，找到 length - k的位置
        int i = length - k;
        cur = head;
        for (int j = 0; j < i - 1; j++) {
            cur = cur.next;
        }
        //cur 节点即为需要截断的节点
        ListNode node1 = cur.next;
        cur.next = null;

        //将head节点 接到 node1 链表后即可

        cur = node1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        return node1;


    }

    public static ListNode rotateRightTwo(ListNode head, int k) {
        //判断 k 的大小和head的长度
        //对k%head。
        //从后向前得到链表，将链表位置接到头链表上
        if (head == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        //再次遍历，找到 length - k的位置
        int i = length - k;
        cur = head;
        for (int j = 0; j < i - 1; j++) {
            cur = cur.next;
        }
        //cur 节点即为需要截断的节点
        ListNode node1 = cur.next;
        cur.next = null;

        //将head节点 接到 node1 链表后即可

        cur = node1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        return node1;


    }
}
