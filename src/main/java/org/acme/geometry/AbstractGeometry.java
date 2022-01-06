package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{
    
    public abstract Geometry clone();

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    };

    public Envelope getEnvelope(){
        EnvelopeBuilder envelope = new EnvelopeBuilder();
        this.accept(envelope);
        return envelope.build();
    }
}
