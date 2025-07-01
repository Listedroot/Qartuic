package me.listed.qartuic.protocol.packet;

public interface PacketHandler {
    void handle(Packet packet) throws Exception;
}
