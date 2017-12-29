package pw.stamina.minecraftapi.mixin.entity.monster;

import net.minecraft.entity.monster.EntityPigZombie;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.monster.ZombiePigman;

@Mixin(EntityPigZombie.class)
public abstract class MixinZombiePigman implements ZombiePigman {

    @Shadow
    private int angerLevel;

    @Override
    public boolean isAngry() {
        return angerLevel > 0;
    }
}
