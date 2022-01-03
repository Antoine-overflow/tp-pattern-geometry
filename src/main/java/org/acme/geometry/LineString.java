package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;
public class LineString implements Geometry{
    private List<Point> points; 

    public LineString(){
        Point p = new Point();
        List<Point> pointsi = new ArrayList<Point>();
        pointsi.add(p);
        this.points = pointsi;
    }

    public LineString(List<Point> pointsi){
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
}
