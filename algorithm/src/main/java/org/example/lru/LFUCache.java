package org.example.lru;

/**
 * 此代码灵感来自下面这篇文章
 * https://mp.weixin.qq.com/s/5VNJhwQpyh5Tqtb4nfhpdA
 */
public class LFUCache {
    // 三个map
    // 一个存储 key 和 value 的 HashMap，即HashMap<key,value>。
    // 一个存储 key 和 freq 的 HashMap，即HashMap<key,freq>。
    // 一个存储 freq 和 key 的 HashMap，即HashMap<freq,key>。

    private int minFreq = 1;
    private int capacity;

    class Node {
        int key;
        int value;
        int freq = 1;
    }
    // 通过封装只需要两个map
    // 一个存储 key 和 Node 的 HashMap，即 HashMap<key,Node>
    // 一个存储 freq 和 Node 的 HashMap，即 HashMap<freq,Node>

//    public LFUCache(int capacity) {
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
















}
