package pw.stamina.minecraftapi.mixin.event.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.render.ScreenRenderEvent;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public class MixinScreenRenderEvent {

    @Inject(method = "updateCameraAndRender", at = @At(value = "INVOKE", shift = At.Shift.AFTER,
            target="Lnet/minecraft/client/gui/GuiIngame;renderGameOverlay(FZII)V"))
    public void emitScreenRenderEvent(float p_updateCameraAndRender_1_, CallbackInfo cbi) {
        MinecraftApi.emitEvent(ScreenRenderEvent.getInstance());
    }
}
