package com.company;

public class Triangle {
    private double a;
    private double h;
    private double field;
    private double perimeter;


    public Triangle(double a, double h) {
        if (a < h) {
            this.a = a;
            this.h = h;
        } else {
            throw new RuntimeException("Złe dane");
        }
    }

    public void calculatePerimeter() {
        perimeter = 3 * a;
    }

    public void calculateField() {
        field = (0.5 * a) * h;
    }

    public double getA() {
        return a;
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
        return "Triangle{" +
                "a=" + a +
                ", h=" + h +
                ", field=" + field +
                ", perimeter=" + perimeter +
                '}';
    }
}


