package org.acme.geometry;

public class WktWriter {
    public WktWriter(){

    }

    public String write(Geometry geometry){
        if (geometry.getType() == "Point"){
            Point point = (Point)geometry;
            if (point.isEmpty()) {
                return "POINT EMPTY";
            }
            return "POINT("+ point.getCoordinate().getX() +" "+point.getCoordinate().getY()+")";
        } else if (geometry.getType() == "LineString") {
            LineString line = (LineString)geometry;
            if (line.isEmpty()) {
                return "LINESTRING EMPTY";
            }
            String r = "LINESTRING(";
            for(int i = 0 ; i < line.getNumPoints() ; i++){
                r += line.getPointN(i).getCoordinate().getX() + " " + line.getPointN(i).getCoordinate().getY();
                if (i != line.getNumPoints() - 1){
                    r += ",";
                }
            }
            r += ")";
            return r;
        } else {
            throw new RuntimeException("geometry type not supported");
        }
    }
}
