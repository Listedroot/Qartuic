package me.listed.qartuic.protocol.packet;

public interface PacketCodec {
    void encode(Packet packet, PacketBuffer buffer) throws Exception;
    void decode(Packet packet, PacketBuffer buffer) throws Exception;
}
