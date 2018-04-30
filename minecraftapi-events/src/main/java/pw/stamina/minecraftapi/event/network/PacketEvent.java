/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
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

package pw.stamina.minecraftapi.event.network;

import pw.stamina.causam.event.AbstractCancellable;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public abstract class PacketEvent extends AbstractCancellable {
    private final Packet packet;
    private final NetworkManager networkManager;

    private List<Packet> packets;

    PacketEvent(Packet packet, NetworkManager networkManager) {
        this.packet = packet;
        this.networkManager = networkManager;
    }

    public final Packet getPacket() {
        return packet;
    }

    public final void sendPacket(Packet packet) {
        networkManager.sendPacket(packet);
    }

    public final void addPacket(Packet packet) {
        if (packets == null) {
            packets = new LinkedList<>();
        }

        packets.add(packet);
    }

    public final void sendPackets(Consumer<Packet> sender) {
        if (packets == null) {
            return;
        }

        packets.forEach(sender);
        packets.clear();
    }
}
