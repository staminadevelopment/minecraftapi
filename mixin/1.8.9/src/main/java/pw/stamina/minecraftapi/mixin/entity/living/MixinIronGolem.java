package pw.stamina.minecraftapi.mixin.entity.living;

import net.minecraft.entity.monster.EntityIronGolem;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.living.IronGolem;

@Implements(@Interface(iface = IronGolem.class, prefix = "api$"))
@Mixin(EntityIronGolem.class)
public abstract class MixinIronGolem implements IronGolem {

    @Intrinsic
    public boolean api$isPlayerCreated() {
        return shadow$isPlayerCreated();
    }

    @Shadow
    public abstract boolean shadow$isPlayerCreated();
}
