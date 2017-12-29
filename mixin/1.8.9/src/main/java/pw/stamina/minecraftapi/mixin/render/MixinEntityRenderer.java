package pw.stamina.minecraftapi.mixin.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.render.EntityRenderer;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public abstract class MixinEntityRenderer implements EntityRenderer {

    @Override
    public void setLightmapUpdateNeeded() {
        this.lightmapUpdateNeeded = true;
    }

    @Shadow private boolean lightmapUpdateNeeded;
}
