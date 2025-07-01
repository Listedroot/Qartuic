package me.listed.qartuic.protocol.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketFactoryRegistry {
    private final Map<Class<? extends Packet>, PacketFactory> factories = new HashMap<>();
    public void register(Class<? extends Packet> clazz, PacketFactory factory) {
        factories.put(clazz, factory);
    }
    public PacketFactory getFactory(Class<? extends Packet> clazz) {
        return factories.get(clazz);
    }
}
