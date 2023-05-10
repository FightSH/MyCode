package org.example.carl.linkedlist;

public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode node = new Solution().removeNthFromEnd(head, 3);

        System.out.println("---");
    }

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dumpy = new ListNode(-1, head);

            ListNode fast = dumpy;
            while (n-- > 0) {
                fast = fast.next;
            }

            ListNode slow = dumpy;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dumpy.next;
        }
    }

}
