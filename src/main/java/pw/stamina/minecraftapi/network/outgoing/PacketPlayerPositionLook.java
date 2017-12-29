package pw.stamina.minecraftapi.network.outgoing;

import pw.stamina.minecraftapi.network.Packet;

public interface PacketPlayerPositionLook extends PacketPlayerPosition, PacketPlayerLook {

    static PacketPlayerPositionLook newInstance(double x, double y, double z,
                                                float yaw, float pitch,
                                                boolean onGround) {
        PacketPlayerPositionLook packet = Packet.newPacket(PacketPlayerPositionLook.class);

        packet.x(x);
        packet.y(y);
        packet.z(z);

        packet.yaw(yaw);
        packet.pitch(pitch);

        packet.onGround(onGround);

        return packet;
    }
}
