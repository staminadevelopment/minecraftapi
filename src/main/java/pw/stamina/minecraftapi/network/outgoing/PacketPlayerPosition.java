package pw.stamina.minecraftapi.network.outgoing;

import pw.stamina.minecraftapi.network.Packet;

public interface PacketPlayerPosition extends PacketPlayer {

    double x();
    void x(double x);

    double y();
    void y(double y);

    double z();
    void z(double z);

    boolean isMoving();

    static PacketPlayerPosition newInstance(double x, double y, double z, boolean onGround) {
        PacketPlayerPosition packet = Packet.newPacket(PacketPlayerPosition.class);

        packet.x(x);
        packet.y(y);
        packet.z(z);
        packet.onGround(onGround);

        return packet;
    }
}
