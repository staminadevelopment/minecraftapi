package pw.stamina.minecraftapi.render;

public interface FontRenderer {

    void drawString(String text, float x, float y, int color);

    void drawStringWithShadow(String text, float x, float y, int color);

    int getStringWidth(String text);

    int getCharacterWidth(char character);
}
