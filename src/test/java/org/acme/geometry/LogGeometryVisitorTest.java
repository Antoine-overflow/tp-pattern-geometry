package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {

    @Test
    public void TestDefaultConstructor() throws UnsupportedEncodingException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Point p = new Point();
        Point p1 = new Point(new Coordinate(2.0 , 5.0));
        Point p2 = new Point(new Coordinate(4.0 , -3.0));
        Point p3 = new Point(new Coordinate(-2.0 , -4.0));

        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        LineString line = new LineString(points);
        LineString l0 = new LineString();

        p.accept(visitor);
        p1.accept(visitor);
        l0.accept(visitor);
        line.accept(visitor);
        String r = os.toString("UTF8");
        Assert.assertEquals("Je suis un point sans coordonnée\nJe suis un point avec x=2.0 et y=5.0\nJe suis une ligne vide\nJe suis une ligne avec 3 points\n", r);

    }
    
}
