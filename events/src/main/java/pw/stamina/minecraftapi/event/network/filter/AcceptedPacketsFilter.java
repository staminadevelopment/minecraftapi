package pw.stamina.minecraftapi.event.network.filter;

import pw.stamina.minecraftapi.event.network.PacketEvent;
import pw.stamina.minecraftapi.network.Packet;

import java.util.function.Predicate;

final class AcceptedPacketsFilter implements Predicate<PacketEvent> {
    private final Class<? extends Packet>[] acceptedPackets;

    AcceptedPacketsFilter(Class<? extends Packet>[] acceptedPackets) {
        this.acceptedPackets = acceptedPackets;
    }

    @Override
    public boolean test(PacketEvent event) {
        Packet packet = event.getPacket();

        for (Class<? extends Packet> acceptedPacket : acceptedPackets) {
            if (acceptedPacket.isInstance(packet)) {
                return true;
            }
        }

        return false;
    }
}
