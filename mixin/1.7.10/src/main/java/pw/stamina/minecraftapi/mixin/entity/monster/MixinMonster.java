package pw.stamina.minecraftapi.mixin.entity.monster;

import net.minecraft.entity.monster.IMob;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.monster.Monster;

@Mixin(IMob.class)
public interface MixinMonster extends Monster {

}
