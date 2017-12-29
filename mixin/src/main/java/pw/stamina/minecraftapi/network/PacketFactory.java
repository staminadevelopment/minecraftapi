package pw.stamina.minecraftapi.network;

import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.network.PacketCreationException;

public interface PacketFactory {

    /**
     * Returns a new instance of the specified <tt>packetClass</tt>.
     *
     * @param packetClass class of the packet to create
     * @param <T> the type of the packet
     * @return a new packet of type <tt>T</tt>
     * @throws PacketCreationException if a packet could not be created
     */
    <T extends Packet> T create(Class<T> packetClass) throws PacketCreationException;
}
