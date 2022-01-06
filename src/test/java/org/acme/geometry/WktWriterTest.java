package org.acme.geometry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class WktWriterTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void TestDefaultWktWriter(){
        Point point1 = new Point(new Coordinate(3.0, 4.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);

        WktWriter writer = new WktWriter();

        Assert.assertEquals("POINT EMPTY", writer.write(new Point()));
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(point1));
        Assert.assertEquals("LINESTRING EMPTY", writer.write(new LineString()));
        Assert.assertEquals("LINESTRING(3.0 4.0,2.0 2.0)", writer.write(line));
    }
    
}
