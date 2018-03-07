package pw.stamina.minecraftapi.module;

import java.util.Objects;

public interface EventConsumer {

    <T> void consumeEvent(T event);

    static EventConsumer empty() {
        return EmptyEventConsumer.INSTANCE;
    }

    static EventConsumer compound(Iterable<EventConsumer> consumers) {
        Objects.requireNonNull(consumers, "consumers");
        return new CompoundEventConsumer(consumers);
    }
}
