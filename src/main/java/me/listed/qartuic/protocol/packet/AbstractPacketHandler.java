package me.listed.qartuic.protocol.packet;

public abstract class AbstractPacketHandler implements PacketHandler {
    public void handle(Packet packet) throws Exception {
        // Implement dispatch logic per packet type if needed
    }
}
