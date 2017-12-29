package pw.stamina.minecraftapi.util;

public final class Rotation {
    private final float yaw, pitch;

    private Rotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public static Rotation from(float yaw, float pitch) {
        return new Rotation(yaw, pitch);
    }
}
