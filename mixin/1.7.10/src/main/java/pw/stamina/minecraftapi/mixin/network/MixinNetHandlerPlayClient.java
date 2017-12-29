package pw.stamina.minecraftapi.mixin.network;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.NetHandlerPlayClient;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.client.network.NetHandlerPlayClient.class)
public abstract class MixinNetHandlerPlayClient implements NetHandlerPlayClient {

    @Override
    public void queuePacket(Packet packet) {
        shadow$addToSendQueue((net.minecraft.network.Packet) packet);
    }

    @Shadow
    public abstract void shadow$addToSendQueue(net.minecraft.network.Packet p_147297_1_);
}
