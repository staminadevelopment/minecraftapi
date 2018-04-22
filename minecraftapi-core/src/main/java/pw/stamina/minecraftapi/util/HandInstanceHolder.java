package pw.stamina.minecraftapi.util;

import pw.stamina.minecraftapi.MinecraftApi;

class HandInstanceHolder {
    static final Hand MAIN_HAND;
    static final Hand OFF_HAND;

    static {
        Hand.Adapter adapter = MinecraftApi.getAdapter().getHandAdapter();

        MAIN_HAND = adapter.getMainHand();
        OFF_HAND = adapter.getOffHand();
    }

    private HandInstanceHolder() {
        throw new Error();
    }
}
