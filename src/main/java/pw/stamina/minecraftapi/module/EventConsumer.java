package pw.stamina.minecraftapi.module;

public interface EventConsumer {

    <T> void consumeEvent(T event);

    static EventConsumer empty() {
        return EmptyEventConsumer.INSTANCE;
    }
}
