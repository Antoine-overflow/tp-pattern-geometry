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

    @Test
    public void testDefaultGeometryWithCachedEnvelopeTriggerTest(){
        Point point = new Point(new Coordinate(2.0 , 3.0));
        Point point2 = new Point(new Coordinate(4.0 , 5.0));

        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point2);
        LineString line = new LineString(points);

        GeometryWithCachedEnvelope geo = new GeometryWithCachedEnvelope(line);

        Envelope e1 = geo.getEnvelope();
        line.translate(2.0, 2.0);
        Envelope e2 = geo.getEnvelope();
        geo.translate(1.0, 1.0);
        Envelope e3 = geo.getEnvelope();

        Assert.assertNotSame(e1, e2);
        Assert.assertNotSame(e1, e3);
    }
}
