package pw.stamina.minecraftapi.event.network;

import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

public final class IncomingPacketEvent extends PacketEvent {

    public IncomingPacketEvent(Packet packet, NetworkManager networkManager) {
        super(packet, networkManager);
    }
}
