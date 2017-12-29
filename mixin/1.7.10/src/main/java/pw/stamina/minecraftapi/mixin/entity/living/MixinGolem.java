package pw.stamina.minecraftapi.mixin.entity.living;

import net.minecraft.entity.monster.EntityGolem;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.living.Golem;

@Mixin(EntityGolem.class)
public abstract class MixinGolem implements Golem {

}
