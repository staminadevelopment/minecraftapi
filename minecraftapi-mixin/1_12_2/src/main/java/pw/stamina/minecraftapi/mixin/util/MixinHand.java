package pw.stamina.minecraftapi.mixin.util;

import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.util.Hand;

@Mixin(EnumHand.class)
public class MixinHand implements Hand {
}
