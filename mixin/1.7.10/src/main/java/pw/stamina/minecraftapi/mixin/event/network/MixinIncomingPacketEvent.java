package pw.stamina.minecraftapi.mixin.event.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.INetHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.network.IncomingPacketEvent;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

import java.util.Queue;

@Mixin(net.minecraft.network.NetworkManager.class)
public abstract class MixinIncomingPacketEvent implements NetworkManager {

    @Shadow @Final private Queue receivedPacketsQueue;
    @Shadow private INetHandler packetListener;
    @Shadow private Channel channel;

    /**
     * @author
     */
    @Overwrite
    protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, net.minecraft.network.Packet p_channelRead0_2_) {
        if (this.channel.isOpen()) {
            IncomingPacketEvent event = new IncomingPacketEvent((Packet) p_channelRead0_2_, this);
            MinecraftApi.emitEvent(event);

            if (event.isCancelled()) {
                return;
            }

            if (p_channelRead0_2_.hasPriority()) {
                p_channelRead0_2_.processPacket(this.packetListener);
            } else {
                this.receivedPacketsQueue.add(p_channelRead0_2_);
            }

            event.sendPackets(this::sendPacket);
        }
    }
}
