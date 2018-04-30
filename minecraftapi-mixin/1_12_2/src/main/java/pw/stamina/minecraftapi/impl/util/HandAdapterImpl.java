package pw.stamina.minecraftapi.impl.util;

import net.minecraft.util.EnumHand;
import pw.stamina.minecraftapi.util.Hand;

public final class HandAdapterImpl implements Hand.Adapter {

    @Override
    public Hand getMainHand() {
        return (Hand) (Object) EnumHand.MAIN_HAND;
    }

    @Override
    public Hand getOffHand() {
        return (Hand) (Object) EnumHand.OFF_HAND;
    }
}
