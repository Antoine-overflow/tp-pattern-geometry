package org.acme.geometry;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(){
        this.x = Double.NaN;
        this.y = Double.NaN;
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
    public Boolean isEmpty(){
    return (Double.isNaN(this.x) || Double.isNaN(this.y));
    }
}

