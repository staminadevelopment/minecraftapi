package pw.stamina.minecraftapi.event.network;

import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

public final class OutgoingPacketEvent extends PacketEvent {

    public OutgoingPacketEvent(Packet packet, NetworkManager networkManager) {
        super(packet, networkManager);
    }
}
