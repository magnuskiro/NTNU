package edu.ntnu.robocode.jsniper.data;

import java.io.Serializable;

//Represents position of the opponent robot on a battlefield.
public class Position implements Serializable {
    public double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position normalized(double width, double height) {
        return new Position(x / width, y / height);
    }
}
