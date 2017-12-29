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
        return func_152114_e((EntityLivingBase) entity);
    }

    @Override
    public String getOwnerIdAsString() {
        return func_152113_b();
    }

    @Shadow public abstract boolean shadow$isTamed();
    @Shadow public abstract EntityLivingBase shadow$getOwner();
    @Shadow public abstract boolean func_152114_e(EntityLivingBase entityIn);
    @Shadow public abstract String func_152113_b();
}
