package pw.stamina.minecraftapi.mixin.event.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.client.Minecraft;
import pw.stamina.minecraftapi.event.render.WorldRenderEvent;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public class MixinWorldRenderEvent {

    @Shadow private net.minecraft.client.Minecraft mc;

    @Inject(method = "renderWorld", at = @At("HEAD"))
    public void emitWorldRenderEvent(float p_renderWorld_1_, long p_renderWorld_2_, CallbackInfo ci) {
        WorldRenderEvent event = new WorldRenderEvent((Minecraft) mc, p_renderWorld_1_);
        MinecraftApi.emitEvent(event);
    }
}
