/*
 * MIT License
 *
 * Copyright (c) 2017 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.mixin.util;

import net.minecraft.util.AxisAlignedBB;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.util.BoundingBox;

@Implements(@Interface(iface = BoundingBox.class, prefix = "api$"))
@Mixin(AxisAlignedBB.class)
public abstract class MixinBoundingBox implements BoundingBox {

    @Shadow @Final public double minX;
    @Shadow @Final public double minY;
    @Shadow @Final public double minZ;
    @Shadow @Final public double maxX;
    @Shadow @Final public double maxY;
    @Shadow @Final public double maxZ;

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
