package pw.stamina.minecraftapi.network;

public interface NetHandlerPlayClient {

    void queuePacket(Packet packet);
}
