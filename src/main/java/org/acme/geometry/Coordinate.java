package org.acme.geometry;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Coordinate(double xi, double yi){
        this.x = xi;
        this.y = yi;
    } 

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
}

