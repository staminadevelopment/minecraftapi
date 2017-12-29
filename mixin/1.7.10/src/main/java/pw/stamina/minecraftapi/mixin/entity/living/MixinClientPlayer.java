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
