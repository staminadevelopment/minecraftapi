package pw.stamina.minecraftapi.event.network.filter;

import pw.stamina.causam.scan.method.filter.AbstractAnnotationBasedFilterFactory;
import pw.stamina.minecraftapi.event.network.PacketEvent;
import pw.stamina.minecraftapi.network.Packet;

import java.util.function.Predicate;

public final class AcceptedPacketsFilterFactory
        extends AbstractAnnotationBasedFilterFactory<PacketEvent, AcceptedPackets> {

    public AcceptedPacketsFilterFactory() {
        super(PacketEvent.class, AcceptedPackets.class);
    }

    @Override
    protected Predicate<PacketEvent> createFilter(AcceptedPackets acceptedPackets) {
        Class<? extends Packet>[] packetTypes = acceptedPackets.value();
        return new AcceptedPacketsFilter(packetTypes);
    }
}
