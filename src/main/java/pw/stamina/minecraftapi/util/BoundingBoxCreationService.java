package pw.stamina.minecraftapi.util;

import pw.stamina.minecraftapi.service.MinecraftApiService;

public interface BoundingBoxCreationService extends MinecraftApiService {

    BoundingBox fromBounds(double x1, double y1, double z1,
                           double x2, double y2, double z2);
}
