package pw.stamina.minecraftapi.event.input;

public final class MouseInputEvent {
    private final int button;
    private final boolean pressed;

    public MouseInputEvent(int button, boolean pressed) {
        this.button = button;
        this.pressed = pressed;
    }

    public int getButton() {
        return button;
    }

    public boolean isPressed() {
        return pressed;
    }
}
