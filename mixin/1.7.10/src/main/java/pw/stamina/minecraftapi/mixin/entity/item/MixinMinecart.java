package pw.stamina.minecraftapi.mixin.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.item.Minecart;

@Mixin(EntityMinecart.class)
public abstract class MixinMinecart implements Minecart {

}
