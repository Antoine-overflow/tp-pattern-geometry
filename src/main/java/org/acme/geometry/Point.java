package org.acme.geometry;

public class Point implements Geometry{
    private Coordinate coordinate; 

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public Point(){
        Coordinate coord = new Coordinate();
        this.coordinate = coord;
    }

    public Point(Coordinate coord){
        if(coord == null){
            coord = new Coordinate();
        }
        this.coordinate = coord;
    }

    public String getType(){
        return "Point";
    }

    public Boolean isEmpty(){
        return this.coordinate.isEmpty();
    }
}
