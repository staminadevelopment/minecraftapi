package pw.stamina.minecraftapi.module;

enum EmptyEventConsumer implements EventConsumer {
    INSTANCE;

    @Override
    public <T> void consumeEvent(T event) {
        // No action
    }
}
