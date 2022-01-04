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

    public void translate(double dx, double dy){
        if(!isEmpty()){
            Coordinate coord = this.getCoordinate();
            Coordinate coord2 = new Coordinate(coord.getX() + dx, coord.getY() + dy);
            this.coordinate = coord2;
        }
    }

    public Point clone(){
        return new Point(this.coordinate);
    }
}
