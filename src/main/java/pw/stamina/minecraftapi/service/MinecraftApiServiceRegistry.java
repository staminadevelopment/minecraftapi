package pw.stamina.minecraftapi.service;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.ServiceLoader;

//TODO: Clean up... A lot
public final class MinecraftApiServiceRegistry {
    private static final ServiceLoader<MinecraftApiService> SERVICES = ServiceLoader.load(MinecraftApiService.class);
    private static final Map<Class<? extends MinecraftApiService>, MinecraftApiService> CACHED_SERVICES
            = new IdentityHashMap<>();

    public static <T extends MinecraftApiService> T getService(Class<T> serviceClass) {
        return serviceClass.cast(CACHED_SERVICES
                .computeIfAbsent(serviceClass, MinecraftApiServiceRegistry::findService));
    }

    private static MinecraftApiService findService(Class<? extends MinecraftApiService> serviceClass) {
        for (MinecraftApiService service : SERVICES) {
            if (serviceClass.isInstance(service)) {
                return service;
            }
        }

        return null;
    }
}
