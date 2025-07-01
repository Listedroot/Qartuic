package me.listed.qartuic.protocol.packet;

public interface Packet {
    int getId();
    void read(PacketBuffer buffer) throws Exception;
    void write(PacketBuffer buffer) throws Exception;
}
