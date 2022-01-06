package org.acme.geometry;

public class Point extends AbstractGeometry{
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
        if (this.coordinate.isEmpty()) {
            this.coordinate = new Coordinate(dx, dy);
        } else {
            this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
        }
        triggerChange();
    }

    public Point clone(){
        return new Point(this.coordinate);
    }

    public Envelope getEnvelope(){
        if (! isEmpty()){
            return new Envelope(this.coordinate, this.coordinate);
        } else {
            return new Envelope();
        }
    }

    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
