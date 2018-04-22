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

package pw.stamina.minecraftapi.mixin.client;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.client.Minecraft;
import pw.stamina.minecraftapi.client.PlayerController;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.impl.MinecraftApiAdapterImpl;
import pw.stamina.minecraftapi.render.EntityRenderer;
import pw.stamina.minecraftapi.render.FontRenderer;
import pw.stamina.minecraftapi.render.RenderManager;
import pw.stamina.minecraftapi.world.World;

@Mixin(net.minecraft.client.Minecraft.class)
public class MixinMinecraft implements Minecraft {

    @Shadow public PlayerControllerMP playerController;
    @Shadow public EntityPlayerSP player;
    @Shadow public WorldClient world;
    @Shadow private int rightClickDelayTimer;

    @Shadow private net.minecraft.client.renderer.entity.RenderManager renderManager;

    @Shadow public net.minecraft.client.renderer.EntityRenderer entityRenderer;

    @Shadow public net.minecraft.client.gui.FontRenderer fontRenderer;

    @Override
    public FontRenderer getFontRenderer() {
        return (FontRenderer) fontRenderer;
    }

    @Override
    public PlayerController getPlayerController() {
        return (PlayerController) playerController;
    }

    @Override
    public ClientPlayer getPlayer() {
        return (ClientPlayer) player;
    }

    @Override
    public World getWorld() {
        return (World) world;
    }

    @Override
    public RenderManager getRenderManager() {
        return (RenderManager) renderManager;
    }

    @Override
    public EntityRenderer getEntityRenderer() {
        return (EntityRenderer) entityRenderer;
    }

    @Override
    public void setRightClickDelay(int delay) {
        rightClickDelayTimer = delay;
    }

    @Override
    public int getRightClickDelay() {
        return rightClickDelayTimer;
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void init(CallbackInfo cbi) {
        MinecraftApi.bootstrap(new MinecraftApiAdapterImpl());
    }
}
