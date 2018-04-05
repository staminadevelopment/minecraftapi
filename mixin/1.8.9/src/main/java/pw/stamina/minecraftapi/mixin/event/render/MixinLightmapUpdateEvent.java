/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.mixin.event.render;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.render.LightmapUpdateEvent;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public abstract class MixinLightmapUpdateEvent {
    private LightmapUpdateEvent event;

    @Inject(method = "updateLightmap", at = @At("HEAD"))
    private void setupLightmapUpdateEvent(float partialTicks, CallbackInfo ci) {
        event = new LightmapUpdateEvent();

        MinecraftApi.emitEvent(event);

        if (event.isLightUpdateForced()) {
            this.lightmapUpdateNeeded = true;
        }
    }

    @Inject(method = "updateLightmap",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/DynamicTexture;updateDynamicTexture()V"))
    private void updateLightmapValues(float partialTicks, CallbackInfo ci) {
        for(int index = 0; index < 256; ++index) {
            int color = lightmapColors[index];

            int alpha = color >> 24 & 255;
            int red = color >> 16 & 255;
            int green = color >> 8 & 255;
            int blue = color & 255;

            int newColor = alpha << 24 | event.calculate(red, green, blue, color);
            lightmapColors[index] = newColor;
        }
    }

    @Shadow private boolean lightmapUpdateNeeded;
    @Shadow @Final private int[] lightmapColors;
}
