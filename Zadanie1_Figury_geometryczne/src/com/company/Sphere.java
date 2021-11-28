package com.company;

import static java.lang.Math.pow;

public class Sphere {

    private double r;
    private double field;
    private double volume;


    public Sphere(double r) {
        this.r = r;
    }

    public void calculateVolume() {
        volume = (1.3333333333) * Math.PI * pow(r, 3);
    }

    public void calculateField() {
        field = 4 * Math.PI * pow(r, 2);
    }



    public double getR() {
        return r;
    }

    public double getField() {
        return field;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                ", r=" + r +
                ", field=" + field +
                ", volume=" + volume +
                '}';
    }
}
