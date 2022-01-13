package org.example.carl.linkedlist;

public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        ListNode root = new ListNode(nums[0]);
        ListNode other = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;
            other = temp;
        }

        removeNthFromEnd(root, 3);

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;

        ListNode fast = dumpy;

        for (int i = 0; i < n; i++) {
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
