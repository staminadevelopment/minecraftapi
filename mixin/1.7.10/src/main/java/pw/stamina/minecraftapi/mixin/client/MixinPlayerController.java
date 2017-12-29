package pw.stamina.minecraftapi.mixin.client;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.client.PlayerController;
import pw.stamina.minecraftapi.entity.Entity;
import pw.stamina.minecraftapi.entity.living.Player;

@Mixin(PlayerControllerMP.class)
public abstract class MixinPlayerController implements PlayerController {

    @Override
    public void attackEntity(Player attacker, Entity target) {
        attackEntity((EntityPlayer) attacker, (net.minecraft.entity.Entity) target);
    }

    @Shadow
    public abstract void attackEntity(EntityPlayer playerIn, net.minecraft.entity.Entity targetEntity);
}
