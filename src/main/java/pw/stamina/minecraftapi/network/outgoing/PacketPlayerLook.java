package pw.stamina.minecraftapi.network.outgoing;

import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.util.Rotation;

public interface PacketPlayerLook extends PacketPlayer {

    float yaw();
    void yaw(float yaw);

    float pitch();
    void pitch(float pitch);

    default Rotation getRotation() {
        return Rotation.from(yaw(), pitch());
    }

    default void setRotation(Rotation rotation) {
        yaw(rotation.getYaw());
        pitch(rotation.getPitch());
    }

    boolean isRotating();

    static PacketPlayerLook newInstance(float yaw, float pitch, boolean onGround) {
        PacketPlayerLook packet = Packet.newPacket(PacketPlayerLook.class);

        packet.yaw(yaw);
        packet.pitch(pitch);
        packet.onGround(onGround);

        return packet;
    }
}
