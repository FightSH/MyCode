package org.example.leetcode.linkedlist;

import java.awt.desktop.AppReopenedEvent;

public class ReverseList206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseListByRecursion(head);

        listNode.print(listNode);

    }


    public static ListNode reverseListByIteration(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = head;
        ListNode cur = prev.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = prev.next;

        }


        return temp.next;
    }

    public static ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return cur;


    }

}
