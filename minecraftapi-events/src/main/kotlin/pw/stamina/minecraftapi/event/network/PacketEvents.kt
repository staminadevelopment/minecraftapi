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

package pw.stamina.minecraftapi.event.network

import pw.stamina.causam.event.AbstractCancellable
import pw.stamina.minecraftapi.network.NetworkManager
import pw.stamina.minecraftapi.network.Packet
import java.util.*

sealed class PacketEvent(val packet: Packet, private val networkManager: NetworkManager) : AbstractCancellable() {

    private val packetsDelegate = lazy { LinkedList<Packet>() }
    private val packets by packetsDelegate

    fun sendPacket(packet: Packet) {
        networkManager.sendPacket(packet)
    }

    fun addPacket(packet: Packet) {
        packets.add(packet)
    }

    fun sendPackets(sender: (Packet) -> Unit) {
        if (!packetsDelegate.isInitialized()) {
            return
        }

        packets.forEach(sender)
        packets.clear()
    }
}

class IncomingPacketEvent(packet: Packet, networkManager: NetworkManager) : PacketEvent(packet, networkManager)

class OutgoingPacketEvent(packet: Packet, networkManager: NetworkManager) : PacketEvent(packet, networkManager)