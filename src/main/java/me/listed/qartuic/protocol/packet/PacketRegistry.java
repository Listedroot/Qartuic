package me.listed.qartuic.protocol.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketRegistry {
    private final Map<Integer, Class<? extends Packet>> idToPacket = new HashMap<>();
    private final Map<Class<? extends Packet>, Integer> packetToId = new HashMap<>();
    private boolean frozen = false;

    public void register(int id, Class<? extends Packet> packetClass) {
        if (frozen) throw new IllegalStateException("PacketRegistry is frozen and cannot be modified");
        idToPacket.put(id, packetClass);
        packetToId.put(packetClass, id);
    }

    public void freeze() {
        frozen = true;
    }

    public Packet createPacket(int id) throws Exception {
        Class<? extends Packet> clazz = idToPacket.get(id);
        if (clazz == null) throw new IllegalArgumentException("Unknown packet id: " + id);
        return clazz.getDeclaredConstructor().newInstance();
    }

    public int getPacketId(Class<? extends Packet> clazz) {
        Integer id = packetToId.get(clazz);
        if (id == null) throw new IllegalArgumentException("Unknown packet class: " + clazz.getName());
        return id;
    }
}
