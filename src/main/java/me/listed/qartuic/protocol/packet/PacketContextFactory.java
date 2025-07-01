package me.listed.qartuic.protocol.packet;

import me.listed.qartuic.protocol.ProtocolState;

public class PacketContextFactory {
    public PacketContext create(ProtocolState state, Packet packet) {
        return new PacketContext(state, packet);
    }
}
