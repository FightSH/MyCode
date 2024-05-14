package org.example.ruangong.year2019;

public class MyStack {

    int count;
    Node head;

    class Node{
        int value;
        Node next;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public MyStack() {
        this.count = 0;
        this.head = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public void push(int value) {
        Node node = new Node(value);
        node.next = this.head;
        this.count++;
        this.head = node;
    }

    public int pop() {
        Node temp = this.head;
        this.head = head.next;
        this.count--;
        return temp.value;
    }


}
