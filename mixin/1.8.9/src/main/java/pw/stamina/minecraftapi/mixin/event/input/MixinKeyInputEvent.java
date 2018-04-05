package pw.stamina.minecraftapi.mixin.event.input;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.input.KeyInputEvent;
import pw.stamina.minecraftapi.event.input.KeyInputType;

@Mixin(Minecraft.class)
public class MixinKeyInputEvent {

    @Inject(method = "runTick", remap = false,
            at = @At(value = "INVOKE",
                    target = "Lorg/lwjgl/input/Keyboard;getEventKey()I",
                    ordinal = 0))
    private void emitKeyInputEvent(CallbackInfo cbi) {
        KeyInputEvent event = new KeyInputEvent(getKeyCode(), getKeyInputType());

        MinecraftApi.emitEvent(event);
    }

    private static int getKeyCode() {
        return Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
    }

    private static KeyInputType getKeyInputType() {
        boolean pressed = Keyboard.getEventKeyState();

        if (Keyboard.isRepeatEvent()) {
            return KeyInputType.REPEAT;
        } else if (pressed) {
            return KeyInputType.PRESS;
        } else {
            return KeyInputType.RELEASE;
        }
    }
}
