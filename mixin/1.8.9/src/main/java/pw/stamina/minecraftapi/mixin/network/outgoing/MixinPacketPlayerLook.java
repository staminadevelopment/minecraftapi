package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerLook;

@Mixin(C03PacketPlayer.C05PacketPlayerLook.class)
public abstract class MixinPacketPlayerLook implements PacketPlayerLook {

}
