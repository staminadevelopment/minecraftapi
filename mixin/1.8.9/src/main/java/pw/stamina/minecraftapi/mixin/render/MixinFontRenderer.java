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
