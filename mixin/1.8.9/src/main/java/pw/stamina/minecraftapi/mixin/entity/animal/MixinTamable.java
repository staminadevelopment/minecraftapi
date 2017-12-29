package pw.stamina.minecraftapi.mixin.entity.animal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.entity.animal.Tamable;
import pw.stamina.minecraftapi.entity.living.Living;

@Implements(@Interface(iface = Tamable.class, prefix = "api$"))
@Mixin(EntityTameable.class)
public abstract class MixinTamable implements Tamable {

    @Intrinsic
    public boolean api$isTamed() {
        return shadow$isTamed();
    }

    @Intrinsic
    public Living api$getOwner() {
        return (Living) shadow$getOwner();
    }

    @Intrinsic
    public boolean api$isOwner(Living entity) {
        return shadow$isOwner((EntityLivingBase) entity);
    }

    @Override
    public String getOwnerIdAsString() {
        return shadow$getOwnerId();
    }

    @Shadow public abstract boolean shadow$isTamed();
    @Shadow public abstract EntityLivingBase shadow$getOwner();
    @Shadow public abstract boolean shadow$isOwner(EntityLivingBase entityIn);
    @Shadow public abstract String shadow$getOwnerId();
}
