package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    
    @Test
    public void testDefaultGeometryWithCachedEnvelopeTest(){
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(line);
       
        Envelope e1 = g.getEnvelope();
        Envelope e2 = g.getEnvelope();

        Assert.assertSame(e1, e2);
    }
}
