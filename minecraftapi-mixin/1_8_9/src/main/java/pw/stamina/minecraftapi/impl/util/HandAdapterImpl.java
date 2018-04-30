package pw.stamina.minecraftapi.impl.util;

import pw.stamina.minecraftapi.util.Hand;

public final class HandAdapterImpl implements Hand.Adapter {

    @Override
    public Hand getMainHand() {
        return HandImpl.MAIN;
    }

    @Override
    public Hand getOffHand() {
        return HandImpl.MAIN;
    }

    private enum HandImpl implements Hand {
        MAIN
    }
}
