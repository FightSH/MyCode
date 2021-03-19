package org.example.leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParkingSystem1603 {

    private Integer big;
    private Integer medium;
    private Integer small;


    public ParkingSystem1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big == 0) {
                    return false;
                } else {
                    big--;
                    return true;
                }
            case 2:
                if (medium == 0) {
                    return false;
                } else {
                    medium--;
                    return true;
                }
            case 3:
                if (small == 0) {
                    return false;
                } else {
                    small--;
                    return true;
                }
        }
        return false;
    }

}
