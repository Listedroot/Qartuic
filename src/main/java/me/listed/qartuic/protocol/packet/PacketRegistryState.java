package me.listed.qartuic.protocol.packet;

import java.util.EnumMap;
import java.util.Map;
import me.listed.qartuic.protocol.ProtocolState;

public class PacketRegistryState {
    private final Map<ProtocolState, PacketRegistry> registries = new EnumMap<>(ProtocolState.class);
    public void register(ProtocolState state, PacketRegistry registry) {
        registries.put(state, registry);
    }
    public PacketRegistry getRegistry(ProtocolState state) {
        return registries.get(state);
    }
}
