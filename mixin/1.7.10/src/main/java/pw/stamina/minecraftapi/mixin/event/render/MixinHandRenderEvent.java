package pw.stamina.minecraftapi.mixin.event.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.client.Minecraft;
import pw.stamina.minecraftapi.event.render.HandRenderEvent;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public class MixinHandRenderEvent {

    @Shadow private net.minecraft.client.Minecraft mc;

    @Inject(method = "renderWorld", cancellable = true, at = @At(value = "INVOKE_STRING",
            target="Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V", args = {"ldc=hand"}))
    private void emitHandRenderEvent(float p_renderWorld_1_, long p_renderWorld_2_, CallbackInfo cbi) {
        HandRenderEvent event = new HandRenderEvent((Minecraft) mc, p_renderWorld_1_);
        MinecraftApi.emitEvent(event);

        if (event.isCancelled()) {
            cbi.cancel();
        }
    }
}
