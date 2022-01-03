package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Point p = new Point();
		Coordinate c = p.getCoordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(4.0,-1.5);
		Point p = new Point(c);
		Coordinate c1 = p.getCoordinate();
		Assert.assertEquals(4.0, c1.getX(), EPSILON);
		Assert.assertEquals(-1.5, c1.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Point p = new Point(c);
		Assert.assertTrue(p.isEmpty());
	}

	@Test
	public void testTranslate(){
		Coordinate c = new Coordinate(0.0, 0.0);
		Point p = new Point(c);
		p.translate(1.0, -1.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-1.0, p.getCoordinate().getY(), EPSILON);
	}
}

