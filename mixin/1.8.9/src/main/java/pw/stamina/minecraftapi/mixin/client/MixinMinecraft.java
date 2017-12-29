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
import pw.stamina.minecraftapi.render.EntityRenderer;
import pw.stamina.minecraftapi.render.FontRenderer;
import pw.stamina.minecraftapi.render.RenderManager;
import pw.stamina.minecraftapi.world.World;

@Mixin(net.minecraft.client.Minecraft.class)
public class MixinMinecraft implements Minecraft {

    @Shadow public PlayerControllerMP playerController;
    @Shadow public EntityPlayerSP thePlayer;
    @Shadow public WorldClient theWorld;
    @Shadow private int rightClickDelayTimer;

    @Shadow private net.minecraft.client.renderer.entity.RenderManager renderManager;

    @Shadow public net.minecraft.client.renderer.EntityRenderer entityRenderer;

    @Shadow public net.minecraft.client.gui.FontRenderer fontRendererObj;

    @Override
    public FontRenderer getFontRenderer() {
        return (FontRenderer) fontRendererObj;
    }

    @Override
    public PlayerController getPlayerController() {
        return (PlayerController) playerController;
    }

    @Override
    public ClientPlayer getPlayer() {
        return (ClientPlayer) thePlayer;
    }

    @Override
    public World getWorld() {
        return (World) theWorld;
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

    @Inject(method = "startGame", at = @At("TAIL"))
    private void startGame(CallbackInfo cbi) {
        MinecraftApi.bootstrap();
    }
}
