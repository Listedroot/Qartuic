package me.listed.qartuic.protocol.packet;

public class PacketInfo {
    public final int id;
    public final Class<? extends Packet> clazz;
    public PacketInfo(int id, Class<? extends Packet> clazz) {
        this.id = id;
        this.clazz = clazz;
    }
}
