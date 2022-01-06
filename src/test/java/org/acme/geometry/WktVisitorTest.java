package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
    
    @Test
    public void testDefaultConstructor(){
        WktVisitor v1 = new WktVisitor();
        WktVisitor v2 = new WktVisitor();

        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        point.accept(v1);
        line.accept(v2);

        System.out.println(v1.getResult());
        Assert.assertEquals("POINT(2.0 3.0)", v1.getResult());
        Assert.assertEquals("LINESTRING(2.0 3.0,4.0 5.0)", v2.getResult());

    }
}