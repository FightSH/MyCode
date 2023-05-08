package org.example.carl.linkedlist;

public class ReverseList206 {

    public static void main(String[] args) {

    }

    static class Solution {

        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }
}
