package org.example.carl.linkedlist;

import java.util.HashSet;

public class DetectCycle142 {
    public static void main(String[] args) {

        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, null)));
        head.next.next.next = new ListNode(-4, head.next);
        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(head);
        ListNode cycle2 = solution.detectCycle2(head);
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            HashSet<Integer> set = new HashSet<>();
            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur.hashCode())) {
                    return cur;
                }
                set.add(cur.hashCode());
                cur = cur.next;
            }

            return null;
        }

        public ListNode detectCycle2(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            ListNode index = null;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                // 相遇节点
                if (slow == fast) {
                    index = slow;
                    break;
                }
            }
            // 无环
            if (index == null) {
                return null;
            }

            slow = head;
            while (true) {
                if (index == slow) {
                    return index;
                }
                index = index.next;
                slow = slow.next;
            }
        }
    }
}
