package pw.stamina.minecraftapi.mixin.network.incoming;

import net.minecraft.network.play.server.S27PacketExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.incoming.ExplosionPacket;

@Mixin(S27PacketExplosion.class)
public class MixinExplosionPacket implements ExplosionPacket {

    @Shadow private float field_149152_f;
    @Shadow private float field_149153_g;
    @Shadow private float field_149159_h;

    @Override
    public float getField_149152_f() {
        return field_149152_f;
    }

    @Override
    public void setField_149152_f(float field_149152_f) {
        this.field_149152_f = field_149152_f;
    }

    @Override
    public float getField_149153_g() {
        return field_149153_g;
    }

    @Override
    public void setField_149153_g(float field_149153_g) {
        this.field_149153_g = field_149153_g;
    }

    @Override
    public float getMotionZ() {
        return field_149159_h;
    }

    @Override
    public void setMotionZ(float motionZ) {
        this.field_149159_h = motionZ;
    }

    @Override
    public void multiplyMotion(double multiplier) {
        field_149152_f *= multiplier;
        field_149153_g *= multiplier;
        field_149159_h *= multiplier;
    }
}
