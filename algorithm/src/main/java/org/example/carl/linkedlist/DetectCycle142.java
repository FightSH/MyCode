package org.example.carl.linkedlist;

public class DetectCycle142 {

    public static void main(String[] args) {

    }


    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            // 有环
            if (fast == slow) {
                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }

        return null;
    }


}
