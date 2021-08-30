package org.example.commandpattern.cuisine.impl;

import org.example.commandpattern.cook.ICook;
import org.example.commandpattern.cuisine.ICuisine;

public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    @Override
    public void cook() {
        cook.doCooking();
    }

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }
}
