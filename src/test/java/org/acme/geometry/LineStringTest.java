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
}
