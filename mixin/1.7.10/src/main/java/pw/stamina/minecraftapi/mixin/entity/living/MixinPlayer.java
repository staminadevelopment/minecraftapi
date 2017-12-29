package pw.stamina.minecraftapi.mixin.entity.living;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.living.Player;

@Mixin(EntityPlayer.class)
public abstract class MixinPlayer implements Player {

}
