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

package pw.stamina.minecraftapi.mixin.network.incoming;

import net.minecraft.network.play.server.S27PacketExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.incoming.ExplosionPacket;

@Mixin(S27PacketExplosion.class)
public class MixinExplosionPacket implements ExplosionPacket {

    @Shadow private float field_149152_f;
    @Shadow private float field_149153_g;
    @Shadow private float field_149159_h;

    @Override
    public float getField_149152_f() {
        return field_149152_f;
    }

    @Override
    public void setField_149152_f(float field_149152_f) {
        this.field_149152_f = field_149152_f;
    }

    @Override
    public float getField_149153_g() {
        return field_149153_g;
    }

    @Override
    public void setField_149153_g(float field_149153_g) {
        this.field_149153_g = field_149153_g;
    }

    @Override
    public float getMotionZ() {
        return field_149159_h;
    }

    @Override
    public void setMotionZ(float motionZ) {
        this.field_149159_h = motionZ;
    }

    @Override
    public void multiplyMotion(double multiplier) {
        field_149152_f *= multiplier;
        field_149153_g *= multiplier;
        field_149159_h *= multiplier;
    }
}
