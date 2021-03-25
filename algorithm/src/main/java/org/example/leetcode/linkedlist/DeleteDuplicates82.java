package org.example.leetcode.linkedlist;

import java.util.HashSet;
import java.util.List;

public class DeleteDuplicates82 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);


        ListNode duplicates = deleteDuplicates(listNode);
        duplicates.print(duplicates);

    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumpy = new ListNode(0, head);

        ListNode cur = dumpy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }


        return dumpy.next;

    }

}
