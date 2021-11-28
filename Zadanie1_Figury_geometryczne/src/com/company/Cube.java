package com.company;

import static java.lang.Math.pow;

public class Cube {
    private double a;
    private double field;
    private double volume;


    public Cube(double a) {
        this.a = a;
    }

    public void calculateVolume() {
        volume = pow(a, 3);
    }

    public void calculateField() {
        field = 6 * pow(a, 2);
    }

    public double getA() {
        return a;
    }

    public double getField() {
        return field;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "a=" + a +
                ", field=" + field +
                ", volume=" + volume +
                '}';
    }
}


