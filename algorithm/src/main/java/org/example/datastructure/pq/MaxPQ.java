package org.example.datastructure.pq;

/**
 * @author SH
 * @date 2021/5/2 11:01
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N = 0;

    public MaxPQ(int nMax) {
        pq = (Key[]) new Comparable[nMax + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[N++] = v;
        swim(N);
    }


    public Key delMax() {
        Key max = pq[1];

        exch(1, N--);

        pq[N + 1] = null;

        sink(1);

        return max;

    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    //上浮，自下至上的堆有序化。通过比较节点和其父节点(k/2)的大小
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //下沉，由上自下的堆有序化.位置k的子节点位置为2k和2k+1
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k,j);
            k = j;
        }
    }




}
