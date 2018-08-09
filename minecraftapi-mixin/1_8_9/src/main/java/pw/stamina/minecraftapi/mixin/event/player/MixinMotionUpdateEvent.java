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

package pw.stamina.minecraftapi.mixin.event.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.event.player.MotionUpdateEvent;
import pw.stamina.minecraftapi.network.NetHandlerPlayClient;

@Mixin(EntityPlayerSP.class)
public abstract class MixinMotionUpdateEvent extends AbstractClientPlayer {

    @Shadow @Final public net.minecraft.client.network.NetHandlerPlayClient sendQueue;

    @Shadow private double lastReportedPosX;
    @Shadow private double lastReportedPosY;
    @Shadow private double lastReportedPosZ;
    @Shadow private float lastReportedYaw;
    @Shadow private float lastReportedPitch;
    @Shadow private boolean serverSneakState;
    @Shadow private boolean serverSprintState;

    private double originalX;
    private double originalZ;

    private float originalYaw;
    private float originalPitch;
    private boolean originalOnGround;

    private AxisAlignedBB originalBoundingBox;
    private MotionUpdateEvent event;

    public MixinMotionUpdateEvent(World p_i45074_1_, GameProfile p_i45074_2_) {
        super(p_i45074_1_, p_i45074_2_);
    }

    @Inject(method = "onUpdateWalkingPlayer", cancellable = true, at = @At("HEAD"))
    public void emitMotionUpdateAndModifyPlayerState(CallbackInfo cbi) {
        storeOriginalState();

        event = createMotionUpdateEvent();
        MinecraftApi.emitEvent(event);

        if (event.isCancelled()) {
            cbi.cancel();
        }

        modifyPlayerState();
    }

    private void storeOriginalState() {
        originalX = posX;
        originalZ = posZ;

        originalYaw = rotationYaw;
        originalPitch = rotationPitch;
        originalOnGround = onGround;

        originalBoundingBox = getEntityBoundingBox();
    }

    private MotionUpdateEvent createMotionUpdateEvent() {
        return new MotionUpdateEvent(
                (ClientPlayer) this,
                posX, posY, posZ,
                lastReportedPosX, lastReportedPosY, lastReportedPosZ,

                rotationYaw, rotationPitch,
                lastReportedYaw, lastReportedPitch,

                isSprinting(), serverSprintState,
                isSneaking(), serverSneakState,
                onGround,

                (NetHandlerPlayClient) sendQueue);
    }

    private void modifyPlayerState() {
        posX = event.getX();
        posZ = event.getZ();
        setEntityBoundingBox(originalBoundingBox.offset(0, event.getOffsetY(), 0));

        rotationYaw = event.getYaw();
        rotationPitch = event.getPitch();
        onGround = event.isOnGround();
    }

    @Redirect(method = "onUpdateWalkingPlayer",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;isSneaking()Z"))
    public boolean redirect_isSneaking(EntityPlayerSP player) {
        return event.isSneaking();
    }

    @Redirect(method = "onUpdateWalkingPlayer",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;isSprinting()Z"))
    public boolean redirect_isSprinting(EntityPlayerSP player) {
        return event.isSprinting();
    }

    @Inject(method = "onUpdateWalkingPlayer", at = @At("TAIL"))
    public void restorePlayerStateAfterMotionUpdateEvent(CallbackInfo cbi) {
        posX = originalX;
        posZ = originalZ;
        setEntityBoundingBox(originalBoundingBox);

        rotationYaw = originalYaw;
        rotationPitch = originalPitch;
        onGround = originalOnGround;

        event.performActions();
        event.sendPackets(((NetHandlerPlayClient) sendQueue)::queuePacket);
    }
}
