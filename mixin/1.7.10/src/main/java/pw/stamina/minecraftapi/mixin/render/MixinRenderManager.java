package pw.stamina.minecraftapi.mixin.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.render.RenderManager;

@Mixin(net.minecraft.client.renderer.entity.RenderManager.class)
public class MixinRenderManager implements RenderManager {

    @Shadow public static double renderPosX;
    @Shadow public static double renderPosY;
    @Shadow public static double renderPosZ;

    @Shadow public double viewerPosX;
    @Shadow public double viewerPosY;
    @Shadow public double viewerPosZ;

    @Override
    public double renderPosX() {
        return renderPosX;
    }

    @Override
    public double renderPosY() {
        return renderPosY;
    }

    @Override
    public double renderPosZ() {
        return renderPosZ;
    }

    @Override
    public double viewerPosX() {
        return viewerPosX;
    }

    @Override
    public double viewerPosY() {
        return viewerPosY;
    }

    @Override
    public double viewerPosZ() {
        return viewerPosZ;
    }

    @Override
    public float getOriginYOffset() {
        return 0;
    }
}
