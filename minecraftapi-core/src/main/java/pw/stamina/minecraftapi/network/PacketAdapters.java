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

package pw.stamina.minecraftapi.network;

import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.MinecraftApiAdapter;
import pw.stamina.minecraftapi.network.incoming.IncomingPacketAdapters;
import pw.stamina.minecraftapi.network.outgoing.OutgoingPacketAdapters;

public final class PacketAdapters {
    private static final IncomingPacketAdapters INCOMING_ADAPTERS;
    private static final OutgoingPacketAdapters OUTGOING_ADAPTERS;

    static {
        MinecraftApiAdapter apiAdapter = MinecraftApi.getAdapter();

        INCOMING_ADAPTERS = apiAdapter.getIncomingPacketAdapters();
        OUTGOING_ADAPTERS = apiAdapter.getOutingPacketAdapters();
    }

    private PacketAdapters() {
        throw new Error();
    }

    public static IncomingPacketAdapters incoming() {
        return INCOMING_ADAPTERS;
    }

    public static OutgoingPacketAdapters outgoing() {
        return OUTGOING_ADAPTERS;
    }
}
