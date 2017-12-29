package pw.stamina.minecraftapi.impl;

import com.google.auto.service.AutoService;
import net.minecraft.util.AxisAlignedBB;
import pw.stamina.minecraftapi.util.BoundingBox;
import pw.stamina.minecraftapi.util.BoundingBoxCreationService;
import pw.stamina.minecraftapi.service.MinecraftApiService;

@AutoService(MinecraftApiService.class)
public final class BoundingBoxCreationServiceImpl implements BoundingBoxCreationService {

    @Override
    public BoundingBox fromBounds(double x1, double y1, double z1,
                                  double x2, double y2, double z2) {
        return (BoundingBox) AxisAlignedBB.getBoundingBox(x1, y1, z1, x2, y2, z2);
    }
}
