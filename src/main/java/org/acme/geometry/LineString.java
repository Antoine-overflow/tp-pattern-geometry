package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;
public class LineString implements Geometry{
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
}
