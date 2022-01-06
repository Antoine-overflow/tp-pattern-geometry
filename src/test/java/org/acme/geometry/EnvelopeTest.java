package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 0.0), new Coordinate(1.0, 1.0));

        Assert.assertEquals(envelope.getXmin(), 0.0, EPSILON);
        Assert.assertEquals(envelope.getYmin(), 0.0, EPSILON);
        Assert.assertEquals(envelope.getXmax(), 1.0, EPSILON);
        Assert.assertEquals(envelope.getYmax(), 1.0, EPSILON);
    }
}