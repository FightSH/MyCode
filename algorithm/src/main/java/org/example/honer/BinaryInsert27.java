package org.example.honer;

public class BinaryInsert27 {
    public static void main(String[] args) {

        System.out.println(insert(1024, 19, 2, 6));
    }

    public static int insert(int n, int m, int j, int i) {
        m <<= j;
        return m + n;
    }
}
