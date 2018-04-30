package pw.stamina.minecraftapi.network.incoming;

import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.network.PacketAdapter;

public interface VelocityPacket extends Packet {

    int getEntityId();

    int getMotionX();
    void setMotionX(int motionX);

    int getMotionY();
    void setMotionY(int motionY);

    int getMotionZ();
    void setMotionZ(int motionZ);

    void multiplyMotion(double multiplier);

    interface Adapter extends PacketAdapter<VelocityPacket> {}
}
