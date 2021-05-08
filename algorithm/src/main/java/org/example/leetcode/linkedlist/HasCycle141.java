package org.example.leetcode.linkedlist;

public class HasCycle141 {


    public static void main(String[] args) {

    }


    public static boolean hasCycle(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;

        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                return true;
            }
        }
        return false;

    }

}
