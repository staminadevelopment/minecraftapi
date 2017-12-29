package pw.stamina.minecraftapi.mixin.entity.animal;

import net.minecraft.entity.passive.EntityHorse;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.animal.Horse;

@Mixin(EntityHorse.class)
public abstract class MixinHorse implements Horse {

}
