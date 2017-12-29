package pw.stamina.minecraftapi.network;

import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.network.PacketCreationException;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class SimplePacketFactory implements PacketFactory {
    private final Map<Class<? extends Packet>, Supplier<?>> packetInstanceCreators;

    public SimplePacketFactory() {
        this.packetInstanceCreators = new IdentityHashMap<>();
    }

    @Override
    public <T extends Packet> T create(Class<T> packetClass) throws PacketCreationException {
        Supplier<?> packetInstanceCreator = packetInstanceCreators.get(packetClass);

        if (packetInstanceCreator == null) {
            //TODO: Throw exception
            return null;
        }

        return packetClass.cast(packetInstanceCreator.get());
    }

    public <T extends Packet> SimplePacketFactory registerPacketInstanceCreator(
            Class<T> packetClass, Supplier<?> packetInstanceCreator) {
        packetInstanceCreators.put(packetClass, packetInstanceCreator);
        return this;
    }
}
