package pw.stamina.minecraftapi.mixin.network.incoming;

import net.minecraft.network.play.server.S12PacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.incoming.VelocityPacket;

@Mixin(S12PacketEntityVelocity.class)
public class MixinVelocityPacket implements VelocityPacket {

    @Shadow private int entityID;

    @Shadow private int motionX;
    @Shadow private int motionY;
    @Shadow private int motionZ;

    @Override
    public int getEntityId() {
        return entityID;
    }

    @Override
    public int getMotionX() {
        return motionX;
    }

    @Override
    public void setMotionX(int motionX) {
        this.motionX = motionX;
    }

    @Override
    public int getMotionY() {
        return motionY;
    }

    @Override
    public void setMotionY(int motionY) {
        this.motionY = motionY;
    }

    @Override
    public int getMotionZ() {
        return motionZ;
    }

    @Override
    public void setMotionZ(int motionZ) {
        this.motionZ = motionZ;
    }

    @Override
    public void multiplyMotion(double multiplier) {
        motionX *= multiplier;
        motionY *= multiplier;
        motionZ *= multiplier;
    }
}
