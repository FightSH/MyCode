package org.example.carl.linkedlist;

/**
 * 02.07 链表相交
 */
public class GetIntersectionNode0207 {

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(8, b);

        ListNode headA = new ListNode(4, new ListNode(1, c));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, c)));

        headA.print();
        System.out.println("");
        headB.print();

        ListNode node = getIntersectionNode(headA, headB);
        System.out.println(node);

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode cur = headA;
        // 链表A长度
        while (cur != null) {
            sizeA++;
            cur = cur.next;
        }

        cur = headB;
        // 链表B长度
        while (cur != null) {
            sizeB++;
            cur = cur.next;
        }

        int value = Math.abs(sizeA - sizeB);

        ListNode longer = sizeA - sizeB > 0 ? headA : headB;

        ListNode shorter = sizeA - sizeB <= 0 ? headA : headB;

        for (int i = 0; i < value; i++) {
            longer = longer.next;
        }

        while (longer != null) {
            if (longer != shorter) {
                longer = longer.next;
                shorter = shorter.next;
            } else {
                return longer;
            }


        }
        return null;

    }

}
