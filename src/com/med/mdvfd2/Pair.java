package com.med.mdvfd2;

public class Pair {
    private double[] container;
    public Pair(double x, double y) {
        container = new double[]{x,y};
    }

    public double x() {
        return container[0];
    }
    public double y() {
        return container[1];
    }


    public void setX(double x) {
        container[0] = x;
    }

    public void setY(double y) {
        container[1] = y;
    }

}
