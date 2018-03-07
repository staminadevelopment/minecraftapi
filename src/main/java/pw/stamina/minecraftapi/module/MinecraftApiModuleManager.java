package pw.stamina.minecraftapi.module;

import pw.stamina.minecraftapi.MinecraftApiAdapter;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class MinecraftApiModuleManager {
    private final ServiceLoader<MinecraftApiModule> modules;
    private final EventConsumer eventConsumer;

    private MinecraftApiModuleManager(ServiceLoader<MinecraftApiModule> modules,
                                      EventConsumer eventConsumer) {
        this.modules = modules;
        this.eventConsumer = eventConsumer;
    }

    public void bootstrap(MinecraftApiAdapter adapter) {
        modules.forEach(module -> module.bootstrap(adapter));
    }

    public <T> void consumeEvent(T event) {
        eventConsumer.consumeEvent(event);
    }

    public static MinecraftApiModuleManager loadModules(ClassLoader classLoader) {
        ServiceLoader<MinecraftApiModule> modules = loadModuleServiceLoader(classLoader);
        EventConsumer eventConsumer = getEventConsumerFromModules(modules);

        return new MinecraftApiModuleManager(modules, eventConsumer);
    }

    private static ServiceLoader<MinecraftApiModule> loadModuleServiceLoader(ClassLoader classLoader) {
        return ServiceLoader.load(MinecraftApiModule.class, classLoader);
    }

    private static EventConsumer getEventConsumerFromModules(ServiceLoader<MinecraftApiModule> modules) {
        List<EventConsumer> eventConsumers = getAllEventConsumerFromModules(modules);

        switch (eventConsumers.size()) {
            case 0:
                return EventConsumer.empty();
            case 1:
                return eventConsumers.get(0);
            default:
                return EventConsumer.compound(eventConsumers);
        }
    }

    private static List<EventConsumer> getAllEventConsumerFromModules(ServiceLoader<MinecraftApiModule> modules) {
        return StreamSupport.stream(modules.spliterator(), false)
                .map(MinecraftApiModule::getEventConsumer)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
