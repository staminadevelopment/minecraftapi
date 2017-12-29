package pw.stamina.minecraftapi.entity.living;

import pw.stamina.minecraftapi.network.NetHandlerPlayClient;

public interface ClientPlayer extends Player {

    NetHandlerPlayClient getSendQueue();

    void swingArm();
}
