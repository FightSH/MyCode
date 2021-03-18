package org.example.leetcode.linkedlist;

public class ReverseBetween92 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);


        ListNode listNode1 = reverseBetween(listNode, 2, 4);
        listNode1.print(listNode1);

//        ListNode reverse = reverse(listNode);
//        print(reverse);

//        print(listNode);

    }


    public static ListNode reverseBetweenTwo(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;


        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;

        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }


        return dummy.next;

    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode pre = dummy;

        //定位截断链表两端
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;


        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode endNode = rightNode.next;

        //切断连接
        rightNode.next = null;

        reverse(leftNode);

        //接回原链表
        pre.next = rightNode;
        leftNode.next = endNode;

        return dummy.next;


    }

    public static ListNode reverse(ListNode head) {

        if (head == null) {
            return null;
        }
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy.next;
        ListNode pCur = null;
        if (prev.next != null) {
            pCur = prev.next;
        }
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }

        return dummy.next;

    }


}
