package org.example.leetcode.hash;

public class MyHashMap706 {

    Node[] array;

    int size;


    /**
     * Initialize your data structure here.
     */
    public MyHashMap706() {
        array = new Node[1 << 15];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        //扩容
        if (++size > array.length * 0.75) {
            resize();
        }

        int index = getIndex(key, array.length);


        Node head = array[index];
        Node cur = new Node(key, value);

        if (head == null) {
            head = new Node();
            array[index] = head;
            head.next = cur;
        } else {

            Node next = head.next;
            while (next != null) {
                if (next.key == key) {
                    next.value = value;
                    return;
                }
                next = next.next;
            }

            next = head.next;
            head.next = cur;
            cur.next = next;

        }


    }

    private void resize() {
        //double size
        Node[] array2 = new Node[array.length << 1];
        //transfer node from old bin into new bin
        for (int i = 0; i < array.length; i++) {
            Node head1 = array[i];
            if (head1 != null) {
                Node h1 = head1.next;
                while (h1 != null) {
                    Node next = h1.next;
                    int key = h1.key;
                    int newIndex = getIndex(key, array2.length);
                    Node head2 = array2[newIndex];
                    if (head2 == null) {
                        head2 = new Node();
                        head2.next = h1;
                        array2[newIndex] = head2;
                    } else {
                        Node temp = head2.next;
                        head2.next = h1;
                        h1.next = temp;
                    }
                    h1 = next;
                }
            }
        }
        array = array2;
    }

    private int getIndex(int key, int length) {
        return key % (length - 1);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndex(key, array.length);
        Node head = array[index];

        //not found
        if (head != null) {
            Node h2 = head.next;
            while (h2 != null) {
                if (h2.key == key) {
                    return h2.value;
                }
                h2 = h2.next;
            }
        }
        return -1;//not found

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = getIndex(key, array.length);
        Node head = array[index];

        if (head == null) {//not found
            return;
        } else {
            Node pre = head;
            Node h2 = head.next;
            while (h2 != null) {
                if (h2.key != key) {
                    pre = h2;
                    h2 = h2.next;
                } else {
                    pre.next = h2.next;
                    size--;
                    return;
                }
            }
        }
    }


    class Node {

        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
