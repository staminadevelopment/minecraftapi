package pw.stamina.minecraftapi.mixin.entity.living;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Session;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.network.NetHandlerPlayClient;

@Mixin(EntityClientPlayerMP.class)
@Implements(@Interface(iface = ClientPlayer.class, prefix = "api$"))
public abstract class MixinClientPlayer extends EntityPlayerSP {

    @Shadow @Final
    public net.minecraft.client.network.NetHandlerPlayClient sendQueue;

    public MixinClientPlayer(Minecraft p_i1238_1_, World p_i1238_2_, Session p_i1238_3_, int p_i1238_4_) {
        super(p_i1238_1_, p_i1238_2_, p_i1238_3_, p_i1238_4_);
    }

    public NetHandlerPlayClient api$getSendQueue() {
        return (NetHandlerPlayClient) sendQueue;
    }

    public void api$swingArm() {
        swingItem();
    }

    @Shadow
    public abstract void swingItem();
}
