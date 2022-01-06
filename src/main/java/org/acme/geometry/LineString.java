package org.acme.geometry;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
public class LineString extends AbstractGeometry{
    private List<Point> points; 

    public LineString(){
        List<Point> pointsi = new ArrayList<Point>();
        this.points = pointsi;
    }

    public LineString(List<Point> pointsi){
        if (pointsi == null){
            pointsi = new ArrayList<Point>();
        }
        this.points = pointsi;
    }

    public int getNumPoints(){
        return this.points.size();
    }

    public Point getPointN(int n){
        return this.points.get(n);
    }

    public String getType(){
        return "LineString";
    }

    public Boolean isEmpty(){
        if(this.getNumPoints() == 0){
            return true;
        }
        return false;
    }

    public void translate(double dx, double dy){
        if(!isEmpty()){
            int nbPoint = getNumPoints();
            for(int k=0; k<nbPoint; k++){
                getPointN(k).translate(dx, dy);
            }
        }
    }

    public LineString clone(){
        return new LineString(this.points);
    }

    public Envelope getEnvelope(){
        EnvelopeBuilder builder = new EnvelopeBuilder();
        if (isEmpty()) {
            return new Envelope();
        } else {
            for(int i = 0 ; i < getNumPoints() ; i++){
                builder.insert(getPointN(i).getCoordinate());
            }
            return builder.build();
        }
    }

    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
