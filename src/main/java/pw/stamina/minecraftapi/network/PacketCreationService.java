package pw.stamina.minecraftapi.network;

import pw.stamina.minecraftapi.service.MinecraftApiService;

public interface PacketCreationService extends MinecraftApiService {

    <T extends Packet> T createPacket(Class<T> packetType);
}
