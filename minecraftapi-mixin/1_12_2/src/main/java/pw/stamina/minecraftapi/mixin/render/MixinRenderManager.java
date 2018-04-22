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

package pw.stamina.minecraftapi.mixin.render;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.render.RenderManager;

@Mixin(net.minecraft.client.renderer.entity.RenderManager.class)
public class MixinRenderManager implements RenderManager {

    @Shadow private double renderPosX;
    @Shadow private double renderPosY;
    @Shadow private double renderPosZ;

    @Shadow public double viewerPosX;
    @Shadow public double viewerPosY;
    @Shadow public double viewerPosZ;

    @Shadow public Entity renderViewEntity;

    @Override
    public double renderPosX() {
        return renderPosX;
    }

    @Override
    public double renderPosY() {
        return renderPosY;
    }

    @Override
    public double renderPosZ() {
        return renderPosZ;
    }

    @Override
    public double viewerPosX() {
        return viewerPosX;
    }

    @Override
    public double viewerPosY() {
        return viewerPosY;
    }

    @Override
    public double viewerPosZ() {
        return viewerPosZ;
    }

    @Override
    public float getOriginYOffset() {
        if (renderViewEntity != null) {
            return renderViewEntity.getEyeHeight();
        } else {
            return 0;
        }
    }
}
