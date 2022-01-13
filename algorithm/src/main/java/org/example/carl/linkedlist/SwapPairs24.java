package org.example.carl.linkedlist;

public class SwapPairs24 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        ListNode root = new ListNode(nums[0]);
        ListNode other = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;
            other = temp;
        }
        root.print();
        ListNode listNode = swapPairs(root);
        listNode.print();
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode cur = dumpy;
        while (cur.next != null && cur.next.next != null) {
            // 需要交换位置的节点
            ListNode a = cur.next;
            ListNode b = cur.next.next.next;

            // 一定要注意链表交换位置时的顺序
            cur.next = cur.next.next;
            cur.next.next = a;
            cur.next.next.next = b;

            cur = cur.next.next;

        }

        return dumpy.next;
    }


}
