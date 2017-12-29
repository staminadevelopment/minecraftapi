package pw.stamina.minecraftapi;

import pw.stamina.minecraftapi.service.MinecraftApiService;
import pw.stamina.minecraftapi.service.MinecraftApiServiceRegistry;

//Services:
// - PacketCreationService
// - BoundingBoxCreationService
// - MinecraftLocatorService

//TODO: Check if standard services are available
public final class MinecraftApi {

    public static void bootstrap() {
        //TODO: Bootstrap project(s) dependent using this API
    }

    public static <T> void emitEvent(T event) {
        //TODO: Delegate events
    }

    public static <T extends MinecraftApiService> T getService(Class<T> serviceClass) {
        return MinecraftApiServiceRegistry.getService(serviceClass);
    }
}
