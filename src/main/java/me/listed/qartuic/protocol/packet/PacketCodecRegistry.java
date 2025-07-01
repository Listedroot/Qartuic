package me.listed.qartuic.protocol.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketCodecRegistry {
    private final Map<Class<? extends Packet>, PacketCodec> codecs = new HashMap<>();
    public void register(Class<? extends Packet> clazz, PacketCodec codec) {
        codecs.put(clazz, codec);
    }
    public PacketCodec getCodec(Class<? extends Packet> clazz) {
        return codecs.get(clazz);
    }
}
