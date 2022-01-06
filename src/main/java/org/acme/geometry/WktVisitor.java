package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
    private StringBuilder buffer;

    public WktVisitor(){
        this.buffer = new StringBuilder();
    }
    
    public void visit(Point point){
        if (point.isEmpty()) {
            this.buffer.append("POINT EMPTY");
        } else {
            this.buffer.append("POINT("+ point.getCoordinate().getX() +" "+point.getCoordinate().getY()+")");
        }
    }

    public void visit(LineString line){
        if (line.isEmpty()) {
            this.buffer.append("LINESTRING EMPTY");
        } else {
            String r = "LINESTRING(";
            for(int i = 0 ; i < line.getNumPoints() ; i++){
                r += line.getPointN(i).getCoordinate().getX() + " " + line.getPointN(i).getCoordinate().getY();
                if (i != line.getNumPoints() - 1){
                    r += ",";
                }
            }
            r += ")";
            this.buffer.append(r);
        }
    }

    public void visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()){
            this.buffer.append("GEOMETRYCOLLECTION EMPTY");
        } else {
            String r = "GEOMETRYCOLLECTION(";
            for (int i = 0 ; i < geometryCollection.getNumGeometries() ; i++) {
                WktVisitor visitor = new WktVisitor();
                geometryCollection.getGeometryN(i).accept(visitor);
                r += visitor.getResult();
                if (i != geometryCollection.getNumGeometries()-1){
                    r += ",";
                }
            }
            this.buffer.append(r);
        }
    }

    public String getResult(){
        return this.buffer.toString();
    };


}
