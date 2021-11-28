package com.company;

public class Rectangle {
    private double a;
    private double b;
    private double field;
    private double perimeter;


    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void calculatePerimeter() {
        perimeter = 2 * a + 2 * b;
    }

    public void calculateField() {
        field = a * b;
    }


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getField() {
        return field;
    }


    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", field=" + field +
                ", perimeter=" + perimeter +
                '}';
    }
}

