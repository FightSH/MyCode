package org.example.carl.linkedlist;

public class SwapPairs24 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));

        Solution solution = new Solution();
        ListNode node = solution.swapPairs(head);

        System.out.println(1);
    }

    static class Solution {

        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dumpy = new ListNode(-1, head);

            ListNode pre = dumpy;

            ListNode cur = head;

            while (cur != null&&cur.next!=null) {

                ListNode next = cur.next;
                pre.next = next;
                cur.next = next.next;
                next.next = cur;

                pre = cur;
                cur = pre.next;
            }

            return dumpy.next;
        }
    }
}
