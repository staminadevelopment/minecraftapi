package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPositionLook;

@Mixin(C03PacketPlayer.C06PacketPlayerPosLook.class)
public abstract class MixinPacketPlayerPositionLook implements PacketPlayerPositionLook {

}
