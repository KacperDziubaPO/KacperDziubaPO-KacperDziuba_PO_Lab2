package com.company;

import static java.lang.Math.pow;

public class Cylinder {

    private double h;
    private double r;
    private double field;
    private double volume;

    public Cylinder(double h, double r) {
        this.h = h;
        this.r = r;



    }

    public void calculateVolume() {
        volume = Math.PI * pow(r, 2) * h;
    }

    public void calculateField() {
        field = 2 * Math.PI * pow(r, 2);
    }

    public double getH() {
        return h;
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
        return "Cylinder{" +
                "h=" + h +
                ", r=" + r +
                ", field=" + field +
                ", volume=" + volume +
                '}';
    }
}
