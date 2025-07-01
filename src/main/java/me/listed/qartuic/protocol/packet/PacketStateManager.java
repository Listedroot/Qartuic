package me.listed.qartuic.protocol.packet;

import me.listed.qartuic.protocol.ProtocolState;

public class PacketStateManager {
    private ProtocolState state;
    public PacketStateManager() {
        this.state = ProtocolState.HANDSHAKE;
    }
    public ProtocolState getState() {
        return state;
    }
    public void setState(ProtocolState state) {
        this.state = state;
    }
}
