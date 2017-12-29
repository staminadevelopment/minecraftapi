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

package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.outgoing.OnGroundPacket;

@Mixin(C03PacketPlayer.class)
public class MixinOnGroundPacket implements OnGroundPacket {

    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
    @Shadow protected boolean moving;
    @Shadow protected boolean rotating;
    @Shadow protected boolean onGround;

    public double x() {
        return x;
    }

    public void x(double x) {
        this.x = x;
    }

    public double y() {
        return y;
    }

    public void y(double y) {
        this.y = y;
    }

    public double z() {
        return z;
    }

    public void z(double z) {
        this.z = z;
    }

    public boolean isMoving() {
        return moving;
    }

    public float yaw() {
        return yaw;
    }

    public void yaw(float yaw) {
        this.yaw = yaw;
    }

    public float pitch() {
        return pitch;
    }

    public void pitch(float pitch) {
        this.pitch = pitch;
    }

    public boolean isRotating() {
        return rotating;
    }

    @Override
    public boolean onGround() {
        return onGround;
    }

    @Override
    public void onGround(boolean onGround) {
        this.onGround = onGround;
    }
}
