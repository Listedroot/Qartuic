package me.listed.qartuic.protocol.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketManager {
    private final Map<Integer, PacketRegistry> stateRegistries = new HashMap<>();

    public void register(int state, PacketRegistry registry) {
        stateRegistries.put(state, registry);
    }

    public PacketRegistry getRegistry(int state) {
        return stateRegistries.get(state);
    }
}
