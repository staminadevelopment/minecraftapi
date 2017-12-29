package pw.stamina.minecraftapi.util;

import pw.stamina.minecraftapi.MinecraftApi;

public interface BoundingBox {

    double getMinX();
    double getMaxX();

    double getMinY();
    double getMaxY();

    double getMinZ();
    double getMaxZ();

    BoundingBox add(double x, double y, double z);
    BoundingBox offset(double x, double y, double z);

    BoundingBox expand(double x, double y, double z);
    BoundingBox contract(double x, double y, double z);

    double calculateXOffset(BoundingBox other, double distance);
    double calculateYOffset(BoundingBox other, double distance);
    double calculateZOffset(BoundingBox other, double distance);

    static BoundingBox fromBounds(double x1, double y1, double z1,
                                  double x2, double y2, double z2) {
        return MinecraftApi.getService(BoundingBoxCreationService.class).fromBounds(x1, y1, z1, x2, y2, z2);
    }

    static BoundingBoxBuilder builder() {
        return new BoundingBoxBuilder();
    }
}
