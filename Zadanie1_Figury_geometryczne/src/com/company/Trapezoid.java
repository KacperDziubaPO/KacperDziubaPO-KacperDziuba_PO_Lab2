package com.company;

public class Trapezoid {

    private double a;
    private double b;
    private double h;
    private double field;
    private double perimeter;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public void calculatePerimeter() {
        perimeter = a + b;
    }

    public void calculateField() {
        field = (0.5 * (a + b)) * h;
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

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "a=" + a +
                ", b=" + b +
                ", h=" + h +
                ", field=" + field +
                ", perimeter=" + perimeter +
                '}';
    }
}

