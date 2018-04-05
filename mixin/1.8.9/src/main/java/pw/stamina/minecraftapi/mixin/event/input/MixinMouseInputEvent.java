package pw.stamina.minecraftapi.mixin.event.input;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.input.KeyInputEvent;
import pw.stamina.minecraftapi.event.input.KeyInputType;
import pw.stamina.minecraftapi.event.input.MouseInputEvent;

@Mixin(Minecraft.class)
public class MixinMouseInputEvent {

    @Inject(method = "runTick", remap = false,
            at = @At(value = "INVOKE",
                    target = "Lorg/lwjgl/input/Mouse;getEventButton()I",
                    ordinal = 0))
    private void emitKeyInputEvent(CallbackInfo cbi) {
        int button = Mouse.getEventButton();

        if (button == -1) {
            return;
        }

        MouseInputEvent event = new MouseInputEvent(button, Mouse.getEventButtonState());

        MinecraftApi.emitEvent(event);
    }
}
