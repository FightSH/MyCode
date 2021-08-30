package org.example.commandpattern.cuisine.impl;

import org.example.commandpattern.cook.ICook;
import org.example.commandpattern.cuisine.ICuisine;

public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    @Override
    public void cook() {
        cook.doCooking();
    }

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }
}
