package pw.stamina.minecraftapi.impl;

import com.google.auto.service.AutoService;
import pw.stamina.minecraftapi.client.MinecraftLocatorService;
import pw.stamina.minecraftapi.client.Minecraft;
import pw.stamina.minecraftapi.service.MinecraftApiService;

@AutoService(MinecraftApiService.class)
public final class MinecraftLocatorServiceImpl implements MinecraftLocatorService {

    @Override
    public Minecraft findMinecraft() {
        return (Minecraft) net.minecraft.client.Minecraft.getMinecraft();
    }
}
