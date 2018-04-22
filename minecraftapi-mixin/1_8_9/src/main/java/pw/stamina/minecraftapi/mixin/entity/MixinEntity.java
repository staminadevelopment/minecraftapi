/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
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

package pw.stamina.minecraftapi.mixin.entity;

import net.minecraft.util.AxisAlignedBB;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.Entity;
import pw.stamina.minecraftapi.util.BoundingBox;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mixin(net.minecraft.entity.Entity.class)
@Implements(@Interface(iface = Entity.class, prefix = "api$"))
public abstract class MixinEntity implements Entity {

    @Shadow private int entityId;
    @Shadow protected UUID entityUniqueID;

    @Shadow public net.minecraft.entity.Entity riddenByEntity;

    @Shadow public double posX;
    @Shadow public double posY;
    @Shadow public double posZ;

    @Shadow public double prevPosX;
    @Shadow public double prevPosY;
    @Shadow public double prevPosZ;

    @Shadow public double motionX;
    @Shadow public double motionY;
    @Shadow public double motionZ;

    @Shadow public float rotationYaw;
    @Shadow public float rotationPitch;

    @Shadow private net.minecraft.util.AxisAlignedBB boundingBox;
    @Shadow public boolean onGround;
    @Shadow public boolean isDead;

    @Shadow public float width;
    @Shadow public float height;

    @Shadow public boolean noClip;
    @Shadow public int ticksExisted;

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public UUID getUniqueId() {
        return entityUniqueID;
    }

    @Override
    public List<Entity> getRiddenByEntities() {
        if (riddenByEntity != null) {
            return Collections.singletonList((Entity) riddenByEntity);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public double posX() {
        return posX;
    }

    @Override
    public void posX(double posX) {
        this.posX = posX;
    }

    @Override
    public double posY() {
        return posY;
    }

    @Override
    public void posY(double posY) {
        this.posY = posY;
    }

    @Override
    public double posZ() {
        return posZ;
    }

    @Override
    public void posZ(double posZ) {
        this.posZ = posZ;
    }

    @Override
    public double prevPosX() {
        return prevPosX;
    }

    @Override
    public double prevPosY() {
        return prevPosY;
    }

    @Override
    public double prevPosZ() {
        return prevPosZ;
    }

    @Override
    public double motionX() {
        return motionX;
    }

    @Override
    public void motionX(double motionX) {
        this.motionX = motionX;
    }

    @Override
    public double motionY() {
        return motionY;
    }

    @Override
    public void motionY(double motionY) {
        this.motionY = motionY;
    }

    @Override
    public double motionZ() {
        return motionZ;
    }

    @Override
    public void motionZ(double motionZ) {
        this.motionZ = motionZ;
    }

    @Override
    public float yaw() {
        return rotationYaw;
    }

    @Override
    public void yaw(float yaw) {
        rotationYaw = yaw;
    }

    @Override
    public float pitch() {
        return rotationPitch;
    }

    @Override
    public void pitch(float pitch) {
        rotationPitch = pitch;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return (BoundingBox) boundingBox;
    }

    @Override
    public boolean onGround() {
        return onGround;
    }

    @Override
    public void onGround(boolean onGround) {
        this.onGround = onGround;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public float width() {
        return width;
    }

    @Override
    public float height() {
        return height;
    }

    @Intrinsic
    public float api$getEyeHeight() {
        return shadow$getEyeHeight();
    }

    @Override
    public boolean isNoClipping() {
        return noClip;
    }

    @Override
    public void setNoClipping(boolean noClipping) {
        noClip = noClipping;
    }

    @Override
    public int getTicksExisted() {
        return ticksExisted;
    }

    @Override
    public float getDistanceToEntity(Entity other) {
        return getDistanceToEntity((net.minecraft.entity.Entity) other);
    }

    @Shadow
    public abstract float getDistanceToEntity(net.minecraft.entity.Entity entityIn);

    @Shadow public abstract boolean isSprinting();

    @Shadow public net.minecraft.entity.Entity ridingEntity;

    @Shadow public abstract void setEntityBoundingBox(AxisAlignedBB p_setEntityBoundingBox_1_);

    @Shadow public abstract AxisAlignedBB getEntityBoundingBox();

    @Shadow
    public abstract float shadow$getEyeHeight();
}
