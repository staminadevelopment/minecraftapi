package pw.stamina.minecraftapi.impl;

import pw.stamina.minecraftapi.util.Hand;

public final class HandAdapter implements Hand.Adapter {

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
