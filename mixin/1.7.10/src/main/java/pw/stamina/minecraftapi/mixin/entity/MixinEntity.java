package pw.stamina.minecraftapi.mixin.entity;

import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.Entity;
import pw.stamina.minecraftapi.util.BoundingBox;

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

    @Shadow @Final public net.minecraft.util.AxisAlignedBB boundingBox;
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
    public Entity getRider() {
        return (Entity) riddenByEntity;
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

    @Shadow
    public abstract float shadow$getEyeHeight();
}
