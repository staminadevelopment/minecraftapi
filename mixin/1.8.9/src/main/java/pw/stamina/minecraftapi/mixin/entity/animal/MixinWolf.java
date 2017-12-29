package pw.stamina.minecraftapi.mixin.entity.animal;

import net.minecraft.entity.passive.EntityWolf;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.animal.Wolf;

@Implements(@Interface(iface = Wolf.class, prefix = "api$"))
@Mixin(EntityWolf.class)
public abstract class MixinWolf implements Wolf {

    @Intrinsic
    public boolean api$isAngry() {
        return shadow$isAngry();
    }

    @Shadow
    public abstract boolean shadow$isAngry();
}
