package org.acme.geometry;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {
    
    @Test
    public void testDefaultAbstractGeometry(){
        // Create Points
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        // Create Line
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        // Tets
        Assert.assertEquals("POINT(2.0 3.0)", point.asText());
        Assert.assertEquals("LINESTRING(2.0 3.0,4.0 5.0)", line.asText());
    }
}
