package pw.stamina.minecraftapi.event.input;

public final class MouseInputEvent {
    private final int button;
    private final boolean down;

    public MouseInputEvent(int button, boolean down) {
        this.button = button;
        this.down = down;
    }

    public int getButton() {
        return button;
    }

    public boolean isDown() {
        return down;
    }
}
