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

package pw.stamina.minecraftapi.mixin.render;

import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.render.FontRenderer;

@Mixin(net.minecraft.client.gui.FontRenderer.class)
@Implements(@Interface(iface = FontRenderer.class, prefix = "api$"))
public abstract class MixinFontRenderer {

    @Shadow public abstract int getCharWidth(char p_getCharWidth_1_);

    @Shadow public abstract int getStringWidth(String p_getStringWidth_1_);

    @Shadow public abstract int drawStringWithShadow(String p_drawStringWithShadow_1_, float p_drawStringWithShadow_2_, float p_drawStringWithShadow_3_, int p_drawStringWithShadow_4_);

    @Shadow protected abstract int renderString(String p_renderString_1_, float p_renderString_2_, float p_renderString_3_, int p_renderString_4_, boolean p_renderString_5_);

    public void api$drawString(String text, float x, float y, int color) {
        renderString(text, x, y, color, false);
    }

    @Intrinsic
    public void api$drawStringWithShadow(String text, float x, float y, int color) {
        drawStringWithShadow(text, x, y, color);
    }

    @Intrinsic
    public int api$getStringWidth(String text) {
        return getStringWidth(text);
    }

    public int api$getCharacterWidth(char character) {
        return getCharWidth(character);
    }
}
