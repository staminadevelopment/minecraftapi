package pw.stamina.minecraftapi.network;

import pw.stamina.minecraftapi.MinecraftApi;

public interface Packet {

    static <T extends Packet> T newPacket(Class<T> packetType) {
        return MinecraftApi.getService(PacketCreationService.class).createPacket(packetType);
    }
}
