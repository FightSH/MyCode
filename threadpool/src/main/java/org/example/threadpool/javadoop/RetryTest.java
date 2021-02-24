package org.example.threadpool.javadoop;

public class RetryTest {


    public static void main(String[] args) {
        retry:
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if(j == 3) {
                    continue retry;
                }
            }
        }
        System.out.print(" >>> OK");



    }

}
