package pw.stamina.minecraftapi.event.network;

import pw.stamina.causam.event.AbstractCancellable;
import pw.stamina.minecraftapi.network.NetworkManager;
import pw.stamina.minecraftapi.network.Packet;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public abstract class PacketEvent extends AbstractCancellable {
    private final NetworkManager networkManager;
    private List<Packet> packets;
    private Packet packet;

    PacketEvent(Packet packet, NetworkManager networkManager) {
        this.packet = packet;
        this.networkManager = networkManager;
    }

    public final Packet getPacket() {
        return packet;
    }

    public final void setPacket(Packet packet) {
        this.packet = packet;
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
