package me.listed.qartuic.protocol.packet;

import me.listed.qartuic.protocol.ProtocolState;

public interface PacketRegistryProvider {
    PacketRegistry getRegistry(ProtocolState state);
}
