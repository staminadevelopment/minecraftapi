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

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.entity.living.Player;
import pw.stamina.minecraftapi.event.render.CapeRenderEvent;

@Mixin(LayerCape.class)
public abstract class MixinCapeRenderEvent {

    private CapeRenderEvent event;

    @Inject(method = "doRenderLayer", at = @At("HEAD"))
    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale, CallbackInfo cbi) {
        event = new CapeRenderEvent((Player) entitylivingbaseIn);
        MinecraftApi.emitEvent(event);
    }

    @Redirect(method = "doRenderLayer", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/entity/AbstractClientPlayer;hasPlayerInfo()Z"))
    public boolean redirect_hasPlayerInfo(AbstractClientPlayer player) {
        if (event.isCapeLocationOverridden()) {
            return true;
        } else {
            return player.hasPlayerInfo();
        }
    }

    @Redirect(method = "doRenderLayer", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/entity/AbstractClientPlayer;isInvisible()Z"))
    public boolean redirect_isInvisible(AbstractClientPlayer player) {
        if (event.isCapeLocationOverridden()) {
            return false;
        } else {
            return player.isInvisible();
        }
    }

    @Redirect(method = "doRenderLayer", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/entity/AbstractClientPlayer;isWearing(Lnet/minecraft/entity/player/EnumPlayerModelParts;)Z"))
    public boolean redirect_isWearing(AbstractClientPlayer player, EnumPlayerModelParts p_175148_1_) {
        if (event.isCapeLocationOverridden()) {
            return true;
        } else {
            return player.isWearing(p_175148_1_);
        }
    }

    @Redirect(method = "doRenderLayer", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/entity/AbstractClientPlayer;getLocationCape()Lnet/minecraft/util/ResourceLocation;"))
    public ResourceLocation redirect_getLocationCape(AbstractClientPlayer player) {
        pw.stamina.minecraftapi.util.ResourceLocation capeLocation = event.getOverridingCapeLocation();

        if (capeLocation != null) {
            return (ResourceLocation) capeLocation;
        } else {
            return player.getLocationCape();
        }
    }
}
