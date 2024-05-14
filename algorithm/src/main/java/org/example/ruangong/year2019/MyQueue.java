package org.example.ruangong.year2019;

public class MyQueue {

    int count;
    Node head;
    Node tail;


    class Node {
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


    public MyQueue() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enQueue(int value) {
        Node node = new Node(value);
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int deQueue() {
        if (count == 0) {
            return -1;
        }
        int value = this.head.value;
        head = head.next;
        count--;
        return value;
    }


}
