package me.listed.qartuic.protocol.packet;

public class HandshakePacket implements Packet {
    public int protocolVersion;
    public String serverAddress;
    public int serverPort;
    public int nextState;

    public int getId() {
        return 0x00;
    }

    public void read(PacketBuffer buffer) throws Exception {
        protocolVersion = buffer.readVarInt();
        serverAddress = buffer.readString();
        serverPort = buffer.readShort() & 0xFFFF;
        nextState = buffer.readVarInt();
    }

    public void write(PacketBuffer buffer) throws Exception {
        buffer.writeVarInt(protocolVersion);
        buffer.writeString(serverAddress);
        buffer.writeShort((short) serverPort);
        buffer.writeVarInt(nextState);
    }
}
