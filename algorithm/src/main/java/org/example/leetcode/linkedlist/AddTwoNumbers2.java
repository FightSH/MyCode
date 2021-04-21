package org.example.leetcode.linkedlist;

public class AddTwoNumbers2 {


    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next = new ListNode(9);

//        head.print(head);
//        System.out.println("----------");

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = new ListNode(9);
//        head2.print(head2);
//        System.out.println("----------");
        ListNode listNode = addTwoNumbers(head, head2);
        listNode.print(listNode);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //链表为null,就补0
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int sum = value1 + value2 + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dumpy.next;

    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//
//        ListNode dumpy = new ListNode(0);
//        ListNode node = new ListNode();
//        dumpy.next = node;
//        int num = 0;
//        while (l1 != null && l2 != null) {
//            int val1 = l1.val;
//            int val2 = l2.val;
//            int result = val1 + val2 + num;
//            num = 0;
//            if (result >= 10) {
//                result = result - 10;
//                num = 1;
//            }
//            node.val = result;
//
//            while (l1.next != null || l2.next != null) {
//                node.next = new ListNode();
//                node = node.next;
//            }
//
//            l1 = l1.next;
//            l2 = l2.next;
//
//        }
//        if (num == 1) {
//            node.next = new ListNode(1);
//            node = node.next;
//            num = 0;
//        }
//
//
//        while (l1 != null) {
//            int result = l1.val + num;
//            num = 0;
//            if (result >= 10) {
//                result = result - 10;
//                num = 1;
//            }
//            node.val = result;
//            if (l1.next != null) {
//                node.next = new ListNode();
//            }
//            l1 = l1.next;
//
//        }
//        while (l2 != null) {
//            int result = l2.val + num;
//            num = 0;
//            if (result >= 10) {
//                result = result - 10;
//                num = 1;
//            }
//            node.val = result;
//            if (l2.next != null) {
//                node.next = new ListNode();
//            }
//            l2 = l2.next;
//        }
//
//        if (num == 1) {
//            node.val = num;
//        }
//
//        return dumpy.next;
//    }


}
