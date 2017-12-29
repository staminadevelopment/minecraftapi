package pw.stamina.minecraftapi.mixin.event.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.INetHandler;
import net.minecraft.network.ThreadQuickExitException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.network.IncomingPacketEvent;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

@Mixin(net.minecraft.network.NetworkManager.class)
public abstract class MixinIncomingPacketEvent implements NetworkManager {

    @Shadow private Channel channel;
    @Shadow private INetHandler packetListener;

    /**
     * @author
     */
    @Overwrite
    protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, net.minecraft.network.Packet p_channelRead0_2_) throws Exception {
        if (this.channel.isOpen()) {
            try {
                IncomingPacketEvent event = new IncomingPacketEvent((Packet) p_channelRead0_2_, this);
                MinecraftApi.emitEvent(event);

                if (event.isCancelled()) {
                    return;
                }

                p_channelRead0_2_.processPacket(this.packetListener);

                event.sendPackets(this::sendPacket);
            } catch (ThreadQuickExitException ignored) {}
        }
    }
}
