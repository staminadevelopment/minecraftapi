package pw.stamina.minecraftapi.event.render;

import pw.stamina.minecraftapi.client.Minecraft;

/**
 * This is essentially pre world render, and HandRenderEvent
 * is post world render.
 * @see HandRenderEvent
 */
public final class WorldRenderEvent {
    private final Minecraft minecraft;
    private final float partialRenderTick;

    public WorldRenderEvent(Minecraft minecraft, float partialRenderTick) {
        this.minecraft = minecraft;
        this.partialRenderTick = partialRenderTick;
    }

    public Minecraft getMinecraft() {
        return minecraft;
    }

    public float getPartialRenderTick() {
        return partialRenderTick;
    }
}
