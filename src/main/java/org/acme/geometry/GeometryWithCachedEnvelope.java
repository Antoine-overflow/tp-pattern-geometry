package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

    Geometry original;
    Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = original.getEnvelope();
    }

    public String getType() {
        return original.getType();
    }

    public Boolean isEmpty() {
        return original.isEmpty();
    }

    public void translate(double dx, double dy) {
        original.translate(dx, dy);
    }

    public Geometry clone() {
        return new GeometryWithCachedEnvelope(this.original);
    }

    public Envelope getEnvelope() {
        return this.cachedEnvelope;
    }

    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);      
    }    
    
}
