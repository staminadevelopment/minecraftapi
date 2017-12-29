package pw.stamina.minecraftapi.mixin.network.outgoing;

import net.minecraft.network.play.client.C01PacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.network.outgoing.PacketChat;

@Mixin(C01PacketChatMessage.class)
public class MixinPacketChat implements PacketChat {

    @Shadow private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String setMessage(String message) {
        return this.message = message;
    }
}
