package pw.stamina.minecraftapi.mixin.network;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.network.NetworkManager.class)
public abstract class MixinNetworkManager implements NetworkManager {

    @Override
    public void sendPacket(Packet packet) {
        sendPacket((net.minecraft.network.Packet) packet);
    }

    @Shadow
    public abstract void sendPacket(net.minecraft.network.Packet packetIn);
}
