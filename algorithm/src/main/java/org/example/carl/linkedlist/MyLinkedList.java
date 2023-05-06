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

    int val;
    MyLinkedList next;
    int size = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(int val, MyLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        MyLinkedList cur = this;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        MyLinkedList oldHead = new MyLinkedList(this.val, next);
        this.val = val;
        this.next = oldHead;
        size++;
    }

    public void addAtTail(int val) {
        MyLinkedList cur = this;
        for (int i1 = 0; i1 < size - 1; i1++) {

            cur = cur.next;
        }
        cur.next = new MyLinkedList(val, null);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else {
            MyLinkedList pre = new MyLinkedList(-1, this);
            MyLinkedList cur = this;

            for (int i1 = 0; i1 < index; i1++) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = new MyLinkedList(val, cur);

            size++;
        }


    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.val = next.val;
            this.next = next.next;
        }else {
            MyLinkedList pre = new MyLinkedList(-1, this);
            MyLinkedList cur = this;
            for (int i1 = 0; i1 < index - 1; i1++) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;

        }
        size--;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[0],[0]]
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList.get(0));

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
    }
}