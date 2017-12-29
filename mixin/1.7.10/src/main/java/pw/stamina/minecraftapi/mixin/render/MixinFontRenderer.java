package pw.stamina.minecraftapi.mixin.render;

import org.spongepowered.asm.mixin.*;
import pw.stamina.minecraftapi.render.FontRenderer;

@Mixin(net.minecraft.client.gui.FontRenderer.class)
@Implements(@Interface(iface = FontRenderer.class, prefix = "api$"))
public abstract class MixinFontRenderer {

    @Shadow public abstract int drawString(String p_drawString_1_, int p_drawString_2_, int p_drawString_3_, int p_drawString_4_);

    @Shadow public abstract int drawStringWithShadow(String p_drawStringWithShadow_1_, int p_drawStringWithShadow_2_, int p_drawStringWithShadow_3_, int p_drawStringWithShadow_4_);

    @Shadow public abstract int getStringWidth(String p_getStringWidth_1_);

    @Shadow public abstract int getCharWidth(char p_getCharWidth_1_);

    public void api$drawString(String text, float x, float y, int color) {
        drawString(text, (int) x, (int) y, color);
    }

    public void api$drawStringWithShadow(String text, float x, float y, int color) {
        drawStringWithShadow(text, (int) x, (int) y, color);
    }

    @Intrinsic
    public int api$getStringWidth(String text) {
        return getStringWidth(text);
    }

    public int api$getCharacterWidth(char character) {
        return getCharWidth(character);
    }
}
