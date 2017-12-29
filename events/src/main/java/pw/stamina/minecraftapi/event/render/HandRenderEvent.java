package pw.stamina.minecraftapi.event.render;

import pw.stamina.causam.event.AbstractCancellable;
import pw.stamina.minecraftapi.client.Minecraft;

public final class HandRenderEvent extends AbstractCancellable {
    private final Minecraft minecraft;
    private final float partialRenderTick;

    public HandRenderEvent(Minecraft minecraft, float partialRenderTick) {
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
