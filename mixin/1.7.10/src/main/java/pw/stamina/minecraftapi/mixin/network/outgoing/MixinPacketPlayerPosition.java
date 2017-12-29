package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPosition;

@Mixin(C03PacketPlayer.C04PacketPlayerPosition.class)
public abstract class MixinPacketPlayerPosition implements PacketPlayerPosition {

}
