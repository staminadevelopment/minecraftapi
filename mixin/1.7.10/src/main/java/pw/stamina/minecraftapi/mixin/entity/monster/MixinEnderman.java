package pw.stamina.minecraftapi.mixin.entity.monster;

import net.minecraft.entity.monster.EntityEnderman;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.monster.Enderman;

@Implements(@Interface(iface = Enderman.class, prefix = "api$"))
@Mixin(EntityEnderman.class)
public abstract class MixinEnderman implements Enderman {

    @Intrinsic
    public boolean api$isScreaming() {
        return shadow$isScreaming();
    }

    @Shadow
    public abstract boolean shadow$isScreaming();
}
