package pw.stamina.minecraftapi.entity;

import pw.stamina.minecraftapi.util.BoundingBox;
import pw.stamina.minecraftapi.util.Rotation;

import java.util.UUID;

public interface Entity {

    int getEntityId();
    UUID getUniqueId();

    Entity getRider();

    double posX();
    void posX(double posX);

    double posY();
    void posY(double posY);

    double posZ();
    void posZ(double posZ);

    double prevPosX();
    double prevPosY();
    double prevPosZ();

    double motionX();
    void motionX(double motionX);

    double motionY();
    void motionY(double motionY);

    double motionZ();
    void motionZ(double motionZ);

    float yaw();
    void yaw(float yaw);

    float pitch();
    void pitch(float pitch);

    default Rotation getRotation() {
        return Rotation.from(yaw(), pitch());
    }

    default void setRotation(Rotation rotation) {
        yaw(rotation.getYaw());
        pitch(rotation.getPitch());
    }

    BoundingBox getBoundingBox();

    boolean onGround();
    void onGround(boolean onGround);

    boolean isDead();

    float width();
    float height();

    float getEyeHeight();

    boolean isNoClipping();
    void setNoClipping(boolean noClipping);

    int getTicksExisted();

    float getDistanceToEntity(Entity other);
}
