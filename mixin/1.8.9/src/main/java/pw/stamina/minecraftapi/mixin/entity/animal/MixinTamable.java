/*
 * MIT License
 *
 * Copyright (c) 2017 Stamina Development
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
