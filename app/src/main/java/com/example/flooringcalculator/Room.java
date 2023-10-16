package com.example.flooringcalculator;

import java.io.Serializable;

public class Room implements Serializable {
    private double width;
    private double length;

    public Room(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getFlooringNeeded() {
        return width * length;
    }
}
