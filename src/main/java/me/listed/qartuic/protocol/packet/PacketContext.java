package me.listed.qartuic.protocol.packet;

import me.listed.qartuic.protocol.ProtocolState;

public class PacketContext {
    public ProtocolState state;
    public Packet packet;
    public PacketContext(ProtocolState state, Packet packet) {
        this.state = state;
        this.packet = packet;
    }
}
