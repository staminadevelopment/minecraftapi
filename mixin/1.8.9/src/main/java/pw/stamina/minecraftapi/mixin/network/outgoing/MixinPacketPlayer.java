package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayer;

@Mixin(C03PacketPlayer.class)
public class MixinPacketPlayer implements PacketPlayer {

    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
    @Shadow protected boolean moving;
    @Shadow protected boolean rotating;
    @Shadow protected boolean onGround;

    public double x() {
        return x;
    }

    public void x(double x) {
        this.x = x;
    }

    public double y() {
        return y;
    }

    public void y(double y) {
        this.y = y;
    }

    public double z() {
        return z;
    }

    public void z(double z) {
        this.z = z;
    }

    public boolean isMoving() {
        return moving;
    }

    public float yaw() {
        return yaw;
    }

    public void yaw(float yaw) {
        this.yaw = yaw;
    }

    public float pitch() {
        return pitch;
    }

    public void pitch(float pitch) {
        this.pitch = pitch;
    }

    public boolean isRotating() {
        return rotating;
    }

    @Override
    public boolean onGround() {
        return onGround;
    }

    @Override
    public void onGround(boolean onGround) {
        this.onGround = onGround;
    }
}
