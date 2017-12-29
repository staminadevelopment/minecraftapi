package pw.stamina.minecraftapi.mixin.world;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.entity.Entity;
import pw.stamina.minecraftapi.world.World;

import java.util.List;

@Mixin(net.minecraft.world.World.class)
public abstract class MixinWorld implements World {

    @Shadow @Final
    public List<net.minecraft.entity.Entity> loadedEntityList;

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> getLoadedEntities() {
        return (List<Entity>) (Object) loadedEntityList;
    }
}
