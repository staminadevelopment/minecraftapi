package pw.stamina.minecraftapi.util;

public final class BoundingBoxBuilder {
    private double x1, y1, z1, x2, y2, z2;

    public BoundingBoxBuilder x1(double x1) {
        this.x1 = x1;
        return this;
    }

    public BoundingBoxBuilder y1(double y1) {
        this.y1 = y1;
        return this;
    }

    public BoundingBoxBuilder z1(double z1) {
        this.z1 = z1;
        return this;
    }

    public BoundingBoxBuilder x2(double x2) {
        this.x2 = x2;
        return this;
    }

    public BoundingBoxBuilder y2(double y2) {
        this.y2 = y2;
        return this;
    }

    public BoundingBoxBuilder z2(double z2) {
        this.z2 = z2;
        return this;
    }

    public BoundingBox build() {
        return BoundingBox.fromBounds(x1, y1, z1, x2, y2, z2);
    }
}