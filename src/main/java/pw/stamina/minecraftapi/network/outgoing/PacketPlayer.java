package pw.stamina.minecraftapi.network.outgoing;

import pw.stamina.minecraftapi.network.Packet;

public interface PacketPlayer extends Packet {

    boolean onGround();
    void onGround(boolean onGround);

    static PacketPlayer newInstance(boolean onGround) {
        PacketPlayer packet = Packet.newPacket(PacketPlayer.class);

        packet.onGround(onGround);

        return packet;
    }
}
