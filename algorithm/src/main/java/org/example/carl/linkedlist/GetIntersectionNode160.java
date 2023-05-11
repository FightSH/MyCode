package org.example.carl.linkedlist;

public class GetIntersectionNode160 {

    public static void main(String[] args) {


    }

    static class Solution {
        // 若链表相交，则两链表直接必然有相同的尾部
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int sizeA = 0;
            ListNode curA = headA;
            while (curA != null) {
                sizeA++;
                curA = curA.next;
            }
            int sizeB = 0;
            ListNode curB = headB;
            while (curB != null) {
                sizeB++;
                curB = curB.next;
            }
            curA = headA;
            curB = headB;

            if (sizeB > sizeA) {
                int tmpLen = sizeA;
                sizeA = sizeB;
                sizeB = tmpLen;
                //2. swap (curA, curB);
                ListNode tmpNode = curA;
                curA = curB;
                curB = tmpNode;
            }

            int gap = sizeA - sizeB;
            while (gap-- > 0) {
                curA = curA.next;
            }
            while (curA != null) {
                if (curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }
}
