package pw.stamina.minecraftapi.event.render;

public final class ScreenRenderEvent {
    private static final ScreenRenderEvent INSTANCE = new ScreenRenderEvent();

    public static ScreenRenderEvent getInstance() {
        return INSTANCE;
    }
}
