package pw.stamina.minecraftapi.mixin.render;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.render.RenderManager;

@Mixin(net.minecraft.client.renderer.entity.RenderManager.class)
public class MixinRenderManager implements RenderManager {

    @Shadow private double renderPosX;
    @Shadow private double renderPosY;
    @Shadow private double renderPosZ;

    @Shadow public double viewerPosX;
    @Shadow public double viewerPosY;
    @Shadow public double viewerPosZ;

    @Shadow public Entity livingPlayer;

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
        if (livingPlayer != null) {
            return livingPlayer.getEyeHeight();
        } else {
            return 0;
        }
    }
}
