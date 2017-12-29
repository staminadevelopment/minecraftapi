package pw.stamina.minecraftapi.network.outgoing;

import pw.stamina.minecraftapi.network.Packet;

public interface PacketChat extends Packet {

    String getMessage();

    String setMessage(String message);
}
