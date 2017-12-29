package pw.stamina.minecraftapi.event.render;

public final class LightmapUpdateEvent {
    private static final LightmapCalculator DEFAULT_LIGHTMAP_CALCULATOR =
            (red, green, blue, alpha, color) -> color;

    private LightmapCalculator calculator = null;

    public LightmapUpdateEvent() {
        this.calculator = DEFAULT_LIGHTMAP_CALCULATOR;
    }

    public void setTransformer(LightmapCalculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(int red, int green, int blue, int alpha, int color) {
        return calculator.calculate(red, green, blue, alpha, color);
    }

    @FunctionalInterface
    public interface LightmapCalculator {

        int calculate(int red, int green, int blue, int alpha, int color);
    }
}
