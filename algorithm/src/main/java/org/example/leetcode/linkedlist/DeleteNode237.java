package org.example.leetcode.linkedlist;

public class DeleteNode237 {
    // 特别的删除方式
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
