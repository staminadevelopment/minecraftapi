package pw.stamina.minecraftapi.client;

import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.render.EntityRenderer;
import pw.stamina.minecraftapi.render.FontRenderer;
import pw.stamina.minecraftapi.render.RenderManager;
import pw.stamina.minecraftapi.world.World;

public interface Minecraft {

    static Minecraft getMinecraft() {
        return MinecraftApi.getService(MinecraftLocatorService.class).findMinecraft();
    }

    FontRenderer getFontRenderer();

    PlayerController getPlayerController();

    ClientPlayer getPlayer();

    World getWorld();

    RenderManager getRenderManager();

    EntityRenderer getEntityRenderer();

    void setRightClickDelay(int delay);

    int getRightClickDelay();
}
