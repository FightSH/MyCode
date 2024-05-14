package org.example.honer;

import java.util.ArrayList;
import java.util.Scanner;

public class BallHeight29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer h = sc.nextInt();
        double sum = 0;
        double lh = h;
        ArrayList<Double> list = new ArrayList<>();
        list.add(h.doubleValue());
        for (int i = 0; i < 5; i++) {
            double h1 = lh / 2;
            if (i < 4) {
                list.add(2 * h1);
            }
            lh = h1;
        }

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
        System.out.println(lh);


    }
}
