package org.example.commandpattern.cuisine.impl;

import org.example.commandpattern.cook.ICook;
import org.example.commandpattern.cuisine.ICuisine;

public class GuangDongCuisine implements ICuisine {

    private ICook cook;

    @Override
    public void cook() {
        cook.doCooking();
    }

    public GuangDongCuisine(ICook cook) {
        this.cook = cook;
    }
}
