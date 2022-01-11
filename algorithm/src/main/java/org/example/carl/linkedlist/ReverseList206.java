package org.example.carl.linkedlist;

public class ReverseList206 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        ListNode other = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;
            other = temp;
        }


    }


    public static ListNode reverseList(ListNode node) {


        ListNode cur = node;
        ListNode temp;
        ListNode pre = null;

        while (cur != null) {
            // 临时存储 cur 的下个节点
            temp = cur.next;
            // 翻转节点
            cur.next = pre;

            // 更新 pre 和 cur 的指针
            pre = cur;
            cur = temp;

        }
        return pre;
    }


}
