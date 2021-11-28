package com.company;

import static java.lang.Math.pow;

public class Cuboid {
    private double a;
    private double b;
    private double h;
    private double field;
    private double volume;


    public Cuboid(double a, double b) {
        this.a = a;
        this.b = b;
        this.h = b;
    }

    public void calculateVolume() {
        volume = a * b * h;
    }

    public void calculateField() {
        field = 2 * (a * b + a * h + b * h);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getH() {
        return h;
    }

    public double getField() {
        return field;
    }


    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "a=" + a +
                ", b=" + b +
                ", h=" + h +
                ", field=" + field +
                ", volume=" + volume +
                '}';
    }
}
