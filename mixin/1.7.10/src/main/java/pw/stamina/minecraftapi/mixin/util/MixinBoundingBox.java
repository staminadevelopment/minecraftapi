package pw.stamina.minecraftapi.mixin.util;

import net.minecraft.util.AxisAlignedBB;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.util.BoundingBox;

@Implements(@Interface(iface = BoundingBox.class, prefix = "api$"))
@Mixin(AxisAlignedBB.class)
public abstract class MixinBoundingBox implements BoundingBox {

    @Shadow public double minX;
    @Shadow public double minY;
    @Shadow public double minZ;
    @Shadow public double maxX;
    @Shadow public double maxY;
    @Shadow public double maxZ;

    @Override
    public double getMinX() {
        return minX;
    }

    @Override
    public double getMaxX() {
        return maxX;
    }

    @Override
    public double getMinY() {
        return minY;
    }

    @Override
    public double getMaxY() {
        return maxY;
    }

    @Override
    public double getMinZ() {
        return minZ;
    }

    @Override
    public double getMaxZ() {
        return maxZ;
    }

    @Override
    public BoundingBox add(double x, double y, double z) {
        return (BoundingBox) shadow$addCoord(x, y, z);
    }

    @Intrinsic
    public BoundingBox api$offset(double x, double y, double z) {
        return (BoundingBox) shadow$offset(x, y, z);
    }

    @Intrinsic
    public BoundingBox api$expand(double x, double y, double z) {
        return (BoundingBox) shadow$expand(x, y, z);
    }

    @Intrinsic
    public BoundingBox api$contract(double x, double y, double z) {
        return (BoundingBox) shadow$contract(x, y, z);
    }

    @Shadow public abstract AxisAlignedBB shadow$addCoord(double x, double y, double z);
    @Shadow public abstract AxisAlignedBB shadow$offset(double x, double y, double z);
    @Shadow public abstract AxisAlignedBB shadow$expand(double x, double y, double z);
    @Shadow public abstract AxisAlignedBB shadow$contract(double x, double y, double z);

    @Override
    public double calculateXOffset(BoundingBox other, double distance) {
        return shadow$calculateXOffset((AxisAlignedBB) other, distance);
    }

    @Override
    public double calculateYOffset(BoundingBox other, double distance) {
        return shadow$calculateYOffset((AxisAlignedBB) other, distance);
    }

    @Override
    public double calculateZOffset(BoundingBox other, double distance) {
        return shadow$calculateZOffset((AxisAlignedBB) other, distance);
    }

    @Shadow public abstract double shadow$calculateXOffset(AxisAlignedBB other, double offsetX);
    @Shadow public abstract double shadow$calculateYOffset(AxisAlignedBB other, double offsetY);
    @Shadow public abstract double shadow$calculateZOffset(AxisAlignedBB other, double offsetZ);
}
