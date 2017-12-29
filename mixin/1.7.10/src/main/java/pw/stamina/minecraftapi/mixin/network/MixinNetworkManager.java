package pw.stamina.minecraftapi.mixin.network;

import io.netty.util.concurrent.GenericFutureListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.network.NetworkManager.class)
public abstract class MixinNetworkManager implements NetworkManager {

    @Override
    public void sendPacket(Packet packet) {
        scheduleOutboundPacket((net.minecraft.network.Packet) packet);
    }

    @Shadow
    public abstract void scheduleOutboundPacket(net.minecraft.network.Packet p_scheduleOutboundPacket_1_, GenericFutureListener... p_scheduleOutboundPacket_2_);
}
