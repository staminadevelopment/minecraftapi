package pw.stamina.minecraftapi.mixin.event.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
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

    // MotionUpdateEvent
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

                isSneaking(), serverSprintState,
                isSprinting(), serverSneakState,
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
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isSneaking()Z"))
    public boolean redirectIsSneaking(Entity entity) {
        return event.isSneaking();
    }

    @Redirect(method = "onUpdateWalkingPlayer",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isSprinting()Z"))
    public boolean redirectIsSprinting(Entity entity) {
        return event.isSneaking();
    }

    @Inject(method = "onUpdateWalkingPlayer", at = @At("TAIL"))
    public void restorePlayerStateAfterMotionUpdateEvent(CallbackInfo cbi) {
        posX = originalX;
        posZ = originalZ;
        setEntityBoundingBox(originalBoundingBox);

        rotationYaw = originalYaw;
        rotationPitch = originalPitch;
        onGround = originalOnGround;

        event.sendPackets(((NetHandlerPlayClient) sendQueue)::queuePacket);
    }
}
