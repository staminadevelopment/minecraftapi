package pw.stamina.minecraftapi.mixin.entity.animal;

import net.minecraft.entity.passive.IAnimals;
import org.spongepowered.asm.mixin.Mixin;
import pw.stamina.minecraftapi.entity.animal.Animal;

@Mixin(IAnimals.class)
public interface MixinAnimal extends Animal {

}
