package pw.stamina.minecraftapi.client;

import pw.stamina.minecraftapi.service.MinecraftApiService;

public interface MinecraftLocatorService extends MinecraftApiService {

    Minecraft findMinecraft();
}
