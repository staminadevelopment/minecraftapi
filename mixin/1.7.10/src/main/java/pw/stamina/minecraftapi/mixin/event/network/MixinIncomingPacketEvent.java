/*
 * MIT License
 *
 * Copyright (c) 2017 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
