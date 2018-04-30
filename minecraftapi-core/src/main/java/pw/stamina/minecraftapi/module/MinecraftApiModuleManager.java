/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.module;

import pw.stamina.minecraftapi.MinecraftApiAdapter;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class MinecraftApiModuleManager {
    private final ServiceLoader<MinecraftApiModule> modules;
    private EventConsumer eventConsumer;

    private MinecraftApiModuleManager(ServiceLoader<MinecraftApiModule> modules) {
        this.modules = modules;
        this.eventConsumer = null;
    }

    public void bootstrap(MinecraftApiAdapter adapter) {
        modules.forEach(module -> module.bootstrap(adapter));
        eventConsumer = getEventConsumerFromModules(modules);
    }

    public <T> void consumeEvent(T event) {
        eventConsumer.consumeEvent(event);
    }

    public static MinecraftApiModuleManager loadModules() {
        ServiceLoader<MinecraftApiModule> modules = loadModuleServiceLoader();

        return new MinecraftApiModuleManager(modules);
    }

    private static ServiceLoader<MinecraftApiModule> loadModuleServiceLoader() {
        return ServiceLoader.load(MinecraftApiModule.class);
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
