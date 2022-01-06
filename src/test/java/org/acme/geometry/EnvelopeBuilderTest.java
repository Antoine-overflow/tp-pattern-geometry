package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        EnvelopeBuilder builder = new EnvelopeBuilder();        
        builder.insert(new Coordinate(0.0, 1.0));
        builder.insert(new Coordinate(1.0, 0.0));
        Envelope result = builder.build();

        Assert.assertEquals(result.getXmax(), 1.0, EPSILON);
        Assert.assertEquals(result.getYmax(), 1.0, EPSILON);
        Assert.assertEquals(result.getXmin(), 0.0, EPSILON);
        Assert.assertEquals(result.getXmin(), 0.0, EPSILON);
    }
}
