package me.listed.qartuic.protocol.packet;

public class PacketException extends Exception {
    public PacketException(String message) {
        super(message);
    }
    public PacketException(String message, Throwable cause) {
        super(message, cause);
    }
}
