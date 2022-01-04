package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		LineString ls = new LineString();
		int nbPoint = ls.getNumPoints();
		Assert.assertEquals(0, nbPoint, EPSILON);
	}

	@Test
	public void testConstructor(){
		Coordinate c1 = new Coordinate(4.0,-1.5);
		Point p1 = new Point(c1);
        Coordinate c2 = new Coordinate(1.0,2.0);
		Point p2 = new Point(c2);
        List<Point> pointsi = new ArrayList<Point>();
        pointsi.add(p1);
        pointsi.add(p2);
        LineString ls = new LineString(pointsi);
        int nbPoint = ls.getNumPoints();
		Assert.assertEquals(2, nbPoint, EPSILON);
        Coordinate c3 = ls.getPointN(0).getCoordinate();
		Assert.assertEquals(4.0, c3.getX(), EPSILON);
		Assert.assertEquals(-1.5, c3.getY(), EPSILON);
        Coordinate c4 = ls.getPointN(1).getCoordinate();
		Assert.assertEquals(1.0, c4.getX(), EPSILON);
		Assert.assertEquals(2.0, c4.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		LineString ls = new LineString();
		Assert.assertTrue(ls.isEmpty());
	}

	@Test
	public void testTranslate(){
		Coordinate c = new Coordinate(0.0, 0.0);
		Point p = new Point(c);
		List<Point> pointsi = new ArrayList<Point>();
		pointsi.add(p);
		LineString ls = new LineString(pointsi);
		ls.translate(1.0, -1.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-1.0, p.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void TestDefaultClone(){
		Point point1 = new Point(new Coordinate(1.0, 1.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);

		LineString line1 = line;
		LineString copy = line.clone();
		copy.translate(10.0, 10.0);

		Assert.assertEquals(line1, line);
	}

	@Test
	public void TestDefaultGetEnvelope(){
		Point point1 = new Point(new Coordinate(1.0, 1.0));
		Point point2 = new Point(new Coordinate(2.0, 2.0));
		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		LineString line = new LineString(points);

		Envelope envelope = line.getEnvelope();

		Assert.assertEquals(1.0, envelope.getXmin(), EPSILON);
		Assert.assertEquals(1.0, envelope.getYmin(), EPSILON);
		Assert.assertEquals(2.0, envelope.getXmax(), EPSILON);
		Assert.assertEquals(2.0, envelope.getYmax(), EPSILON);
	}
}
