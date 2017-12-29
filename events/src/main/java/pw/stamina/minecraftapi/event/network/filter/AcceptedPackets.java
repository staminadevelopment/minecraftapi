package pw.stamina.minecraftapi.event.network.filter;

import pw.stamina.causam.scan.method.filter.Filter;
import pw.stamina.minecraftapi.network.Packet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Filter(AcceptedPacketsFilterFactory.class)
public @interface AcceptedPackets {

    Class<? extends Packet>[] value();
}
