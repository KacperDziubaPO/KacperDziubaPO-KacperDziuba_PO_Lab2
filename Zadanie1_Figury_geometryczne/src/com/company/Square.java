package com.company;

public class Square {
    private double a;
    private double field;
    private double perimeter;

    public Square(double a) {
        this.a = a;

    }

    public void calculateField() {
        field = a * a;
    }

    public void calculatePerimeter() {
        perimeter = 4 * a;
    }

    public double getA() {
        return a;
    }

    public double getField() {
        return field;
    }

    public double getPerimeter() {
        return perimeter;
    }


    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", field=" + field +
                ", circuit=" + perimeter +
                '}';
    }
}
