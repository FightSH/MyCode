package org.example.carl.linkedlist;

public class RemoveElements203 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4, 5};

        ListNode root = new ListNode(nums[0]);
        ListNode other = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;
            other = temp;
        }

        removeElements(3, root).print();

    }

    public static ListNode removeElements(int value, ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dumpy = new ListNode(-1, head);

        ListNode pre = dumpy;
        ListNode cur = head;


        while (cur != null) {
            if (cur.val == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }


        return dumpy.next;
    }

}
