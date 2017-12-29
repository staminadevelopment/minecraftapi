package pw.stamina.minecraftapi.mixin.event.network;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.network.OutgoingPacketEvent;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.client.network.NetHandlerPlayClient.class)
public class MixinOutgoingPacketEvent {

    @Shadow
    @Final
    private net.minecraft.network.NetworkManager netManager;

    /**
     * @author
     */
    @Overwrite
    public void addToSendQueue(net.minecraft.network.Packet p_addToSendQueue_1_) {
        OutgoingPacketEvent event = new OutgoingPacketEvent(
                (Packet) p_addToSendQueue_1_,
                (NetworkManager) this.netManager);

        MinecraftApi.emitEvent(event);

        if (event.isCancelled()) {
            return;
        }

        this.netManager.scheduleOutboundPacket(p_addToSendQueue_1_);

        NetworkManager networkManager = (NetworkManager) this.netManager;
        event.sendPackets(networkManager::sendPacket);
    }
}
