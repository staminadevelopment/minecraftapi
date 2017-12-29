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

    @Inject(method = "renderWorldPass", cancellable = true, at = @At(value = "INVOKE_STRING",
            target="Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V", args = {"ldc=hand"}))
    private void emitHandRenderEvent(int p_renderWorldPass_1_, float p_renderWorldPass_2_, long p_renderWorldPass_3_, CallbackInfo cbi) {
        HandRenderEvent event = new HandRenderEvent((Minecraft) mc, p_renderWorldPass_2_);
        MinecraftApi.emitEvent(event);

        if (event.isCancelled()) {
            cbi.cancel();
        }
    }
}
