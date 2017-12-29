package pw.stamina.minecraftapi.mixin.network;

import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.network.Packet.class)
public interface MixinPacket extends Packet {

}
