package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{
    PrintStream out;
    
    public LogGeometryVisitor(){
        this.out = System.out;
    }
    public LogGeometryVisitor(PrintStream out){
        this.out = out;
    }

    public void visit(Point point){
        if(point.isEmpty()){
            this.out.println("Je suis un point sans coordonnée");
        } else {
            double x = point.getCoordinate().getX();
            double y = point.getCoordinate().getY();
            this.out.println("Je suis un point avec x=" + x + " et y=" + y);
        }
    }

    public void visit(LineString line) {
        if (line.isEmpty()){
            this.out.println("Je suis une ligne vide");
        } else {
            int n = line.getNumPoints();
            this.out.println("Je suis une ligne avec " + n + " points");
        }
        
    }
}
