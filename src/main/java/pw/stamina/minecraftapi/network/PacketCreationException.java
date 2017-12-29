package pw.stamina.minecraftapi.network;

public final class PacketCreationException extends RuntimeException {

    public PacketCreationException(String message) {
        super(message);
    }

    public PacketCreationException(Throwable cause) {
        super(cause);
    }
}
