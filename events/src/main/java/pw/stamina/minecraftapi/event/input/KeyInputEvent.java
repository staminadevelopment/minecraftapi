package pw.stamina.minecraftapi.event.input;

public final class KeyInputEvent {
    private final int key;
    private final KeyInputType inputType;

    public KeyInputEvent(int key, KeyInputType inputType) {
        this.key = key;
        this.inputType = inputType;
    }

    public int getKey() {
        return key;
    }

    public KeyInputType getInputType() {
        return inputType;
    }
}
