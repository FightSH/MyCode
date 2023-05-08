package org.example.carl.linkedlist;

/*
MyLinkedList() 初始化 MyLinkedList 对象。
单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将不会插入到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
*/
class MyLinkedList {

    int size;

    ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public MyLinkedList() {
        int size = 0;
        this.head = new ListNode(-1, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode pre = head;
        while (index-- > 0) {
            pre = pre.next;
        }
        return pre.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (index-- > 0) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = new ListNode(val, cur);

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }

        ListNode pre = head;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[0],[0]]
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(0);
//        System.out.println(myLinkedList.get(0));

//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[1],[1]]
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(1);
//        System.out.println(myLinkedList.get(1));

//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//        [[]              ,[7],         [2],         [1],         [3,0],     [2],           [6],          [4],    [4],   [4],         [5,0],       [6]]
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.addAtHead(1);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

//        ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
//        [[],            [2],            [1],        [2],        [7],            [3],        [2],        [5],        [5],    [5],    [6],            [4]]

//        myLinkedList.addAtHead(4);
//
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(3);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtTail(5);
//        System.out.println(myLinkedList.get(5));
//        myLinkedList.deleteAtIndex(6);
//        myLinkedList.deleteAtIndex(4);
//        System.out.println(myLinkedList.get(0));


//        ["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
//        [[],              [4],        [1],   [1],         [5],        [3],            [7],    [3],  [3],  [3],   [1],        [4]]
        myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);



    }
}