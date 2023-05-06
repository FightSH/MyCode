package org.example.carl.linkedlist;

import java.util.List;

public class RemoveElements203 {
    public static void main(String[] args) {

    }


    static class Solution {
        public static ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode dumpy = new ListNode(0, head);
            ListNode pre = dumpy;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return dumpy.next;
        }
    }

}


