package org.example.leetcode.hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class MyHashSet705 {

    private final static int BASE = 919;

    private LinkedList<Integer>[] data;


    public MyHashSet705() {
        this.data = new LinkedList[BASE];
    }

    public int getHash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int index = getHash(key);
        LinkedList<Integer> datum = data[index];
        if (datum == null) {
            datum = new LinkedList<Integer>();
            data[index] = datum;
        }
        if (!datum.contains(key)) {
            datum.addLast(key);
        }


    }

    public void remove(int key) {
        int index = getHash(key);
        LinkedList<Integer> datum = data[index];
        if (datum == null) {
            return;
        }
        datum.removeIf(integer -> integer == key);


    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = getHash(key);
        LinkedList datum = data[index];
        if (datum == null) {
            return false;
        }
        return datum.contains(key);
    }
}
