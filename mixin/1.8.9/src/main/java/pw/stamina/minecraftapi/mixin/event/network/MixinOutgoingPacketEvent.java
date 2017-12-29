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

    @Shadow @Final private net.minecraft.network.NetworkManager netManager;

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

        this.netManager.sendPacket(p_addToSendQueue_1_);

        NetworkManager networkManager = (NetworkManager) this.netManager;
        event.sendPackets(networkManager::sendPacket);
    }
}
