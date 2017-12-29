package pw.stamina.minecraftapi.mixin.entity.living;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.network.NetHandlerPlayClient;

@Mixin(EntityPlayerSP.class)
@Implements(@Interface(iface = ClientPlayer.class, prefix = "api$"))
public abstract class MixinClientPlayer extends AbstractClientPlayer {

    @Shadow @Final public net.minecraft.client.network.NetHandlerPlayClient sendQueue;

    public MixinClientPlayer(World p_i45074_1_, GameProfile p_i45074_2_) {
        super(p_i45074_1_, p_i45074_2_);
    }

    public NetHandlerPlayClient api$getSendQueue() {
        return (NetHandlerPlayClient) sendQueue;
    }

    public void api$swingArm() {
        swingItem();
    }
}
