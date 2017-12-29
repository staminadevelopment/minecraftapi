package pw.stamina.minecraftapi.mixin.entity.monster;

import net.minecraft.entity.monster.EntityPigZombie;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.monster.ZombiePigman;

@Implements(@Interface(iface = ZombiePigman.class, prefix = "api$"))
@Mixin(EntityPigZombie.class)
public abstract class MixinZombiePigman implements ZombiePigman {

    @Intrinsic
    public boolean api$isAngry() {
        return shadow$isAngry();
    }

    @Shadow
    public abstract boolean shadow$isAngry();
}
