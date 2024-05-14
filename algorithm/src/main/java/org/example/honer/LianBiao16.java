package org.example.honer;

import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LianBiao16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(" ");

        int n = Integer.parseInt(params[0]);
        int pivot = Integer.parseInt(params[1]);

        String[] strList = sc.nextLine().split(" ");
        ListNode head = new ListNode(Integer.parseInt(strList[0]));
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(Integer.parseInt(strList[i]));
            cur = cur.next;
        }
        head = partition(head, pivot);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static ListNode partition(ListNode node, int target) {
        ListNode less = new ListNode(-1);
        ListNode equal = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode head1 = less;
        ListNode head2 = equal;
        ListNode head3 = great;
        while (node != null) {
            if (node.val < target) {
                less.next = new ListNode(node.val);
                less = less.next;
            } else if (node.val > target) {
                great.next = new ListNode(node.val);
                great = great.next;
            } else {
                equal.next = new ListNode(node.val);
                equal = equal.next;
            }
            node = node.next;
        }
        if (head3.next != null) {
            equal.next = head3.next;
            head3.next = null;       // 把大于链表头部的哑节点断开
        }
        if (head2.next != null) {
            less.next = head2.next;
            head2.next = null;       // 把等于链表头部的哑节点断开
        }
        return head1.next;
    }
}
