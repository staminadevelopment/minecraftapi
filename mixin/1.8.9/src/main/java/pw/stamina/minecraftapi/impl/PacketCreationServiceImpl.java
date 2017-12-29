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

package pw.stamina.minecraftapi.impl;

import com.google.auto.service.AutoService;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.network.PacketCreationService;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayer;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerLook;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPosition;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPositionLook;
import pw.stamina.minecraftapi.network.PacketFactory;
import pw.stamina.minecraftapi.network.SimplePacketFactory;
import pw.stamina.minecraftapi.service.MinecraftApiService;

@AutoService(MinecraftApiService.class)
public final class PacketCreationServiceImpl implements PacketCreationService {
    private final PacketFactory factory = new SimplePacketFactory()
            .registerPacketInstanceCreator(PacketPlayer.class, C03PacketPlayer::new)
            .registerPacketInstanceCreator(PacketPlayerPosition.class, C04PacketPlayerPosition::new)
            .registerPacketInstanceCreator(PacketPlayerLook.class, C05PacketPlayerLook::new)
            .registerPacketInstanceCreator(PacketPlayerPositionLook.class, C06PacketPlayerPosLook::new);

    @Override
    public <T extends Packet> T createPacket(Class<T> packetType) {
        return factory.create(packetType);
    }
}
