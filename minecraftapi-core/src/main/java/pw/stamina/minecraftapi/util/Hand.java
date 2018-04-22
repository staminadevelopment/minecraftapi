package pw.stamina.minecraftapi.util;

public interface Hand {

    static Hand main() {
        return HandInstanceHolder.MAIN_HAND;
    }

    static Hand off() {
        return HandInstanceHolder.OFF_HAND;
    }

    interface Adapter {

        Hand getMainHand();

        Hand getOffHand();
    }
}
