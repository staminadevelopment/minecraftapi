package pw.stamina.minecraftapi.mixin.entity.item;

import net.minecraft.entity.item.EntityBoat;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.item.Boat;

@Mixin(EntityBoat.class)
public abstract class MixinBoat implements Boat {

}
