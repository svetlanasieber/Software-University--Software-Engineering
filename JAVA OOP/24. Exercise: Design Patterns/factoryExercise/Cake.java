package com.company.factoryPattern.factoryExercise;

import com.company.factoryPattern.solution.CakeInt;

public abstract class Cake implements CakeInt {
    public double diameter;
    public double price;
    public int pieces;

    public Cake(double diameter, double price, int pieces) {
        this.diameter = diameter;
        this.price = price;
        this.pieces = pieces;
    }
}