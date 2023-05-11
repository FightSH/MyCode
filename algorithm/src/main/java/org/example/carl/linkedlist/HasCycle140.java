package org.example.carl.linkedlist;

public class HasCycle140 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, null);
        ListNode head = new ListNode(1, new ListNode(2, null));
        System.out.println(new Solution().hasCycle(head));
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }
}
