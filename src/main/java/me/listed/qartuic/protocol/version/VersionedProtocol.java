package me.listed.qartuic.protocol.version;

import java.net.Socket;

import me.listed.qartuic.protocol.packet.Packet;
import me.listed.qartuic.protocol.packet.PacketBuffer;
import me.listed.qartuic.protocol.packet.PacketRegistry;
import me.listed.qartuic.protocol.packet.PacketSession;
import me.listed.qartuic.protocol.ProtocolState;

public interface VersionedProtocol {
    void handleHandshake(PacketBuffer buffer, PacketSession session) throws Exception;
    void processPacket(PacketBuffer buffer, PacketSession session) throws Exception;
    void sendPacket(PacketBuffer buffer, Packet packet, PacketSession session) throws Exception;
    int getProtocolVersion();
    PacketRegistry getPacketRegistry(ProtocolState state);
}
