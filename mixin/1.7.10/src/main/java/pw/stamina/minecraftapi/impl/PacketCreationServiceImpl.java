package pw.stamina.minecraftapi.impl;

import com.google.auto.service.AutoService;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.network.PacketCreationService;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayer;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerLook;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPosition;
import pw.stamina.minecraftapi.network.outgoing.PacketPlayerPositionLook;
import pw.stamina.minecraftapi.network.PacketFactory;
import pw.stamina.minecraftapi.network.SimplePacketFactory;
import pw.stamina.minecraftapi.service.MinecraftApiService;

@AutoService(MinecraftApiService.class)
public final class PacketCreationServiceImpl implements PacketCreationService {
    private final PacketFactory factory = new SimplePacketFactory()
            .registerPacketInstanceCreator(PacketPlayer.class, C03PacketPlayer::new)
            .registerPacketInstanceCreator(PacketPlayerPosition.class, C04PacketPlayerPosition::new)
            .registerPacketInstanceCreator(PacketPlayerLook.class, C05PacketPlayerLook::new)
            .registerPacketInstanceCreator(PacketPlayerPositionLook.class, C06PacketPlayerPosLook::new);

    @Override
    public <T extends Packet> T createPacket(Class<T> packetType) {
        return factory.create(packetType);
    }
}
