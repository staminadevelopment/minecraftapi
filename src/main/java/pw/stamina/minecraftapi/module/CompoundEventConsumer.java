package pw.stamina.minecraftapi.module;

final class CompoundEventConsumer implements EventConsumer {
    private final Iterable<EventConsumer> consumers;

    CompoundEventConsumer(Iterable<EventConsumer> consumers) {
        this.consumers = consumers;
    }

    @Override
    public <T> void consumeEvent(T event) {
        consumers.forEach(consumer -> consumer.consumeEvent(event));
    }
}
