package pw.stamina.minecraftapi.mixin.entity.living;

import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.living.Living;

@Implements(@Interface(iface = Living.class, prefix = "api$"))
@Mixin(EntityLivingBase.class)
public abstract class MixinLiving implements Living {

    @Intrinsic
    public float api$getHealth() {
        return shadow$getHealth();
    }

    @Intrinsic
    public void api$setHealth(float health) {
        shadow$setHealth(health);
    }

    @Shadow
    public abstract float shadow$getHealth();

    @Shadow
    public abstract void shadow$setHealth(float health);
}
