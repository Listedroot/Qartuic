package me.listed.qartuic.protocol.v1_10;

import me.listed.qartuic.protocol.version.VersionedProtocol;
import me.listed.qartuic.protocol.packet.PacketBuffer;
import me.listed.qartuic.protocol.packet.Packet;
import me.listed.qartuic.protocol.packet.PacketRegistry;
import me.listed.qartuic.protocol.packet.HandshakePacket;
import me.listed.qartuic.protocol.ProtocolState;
import me.listed.qartuic.protocol.packet.PacketSession;
import java.util.concurrent.locks.ReentrantLock;

public class ProtocolImpl implements VersionedProtocol {
    private final PacketRegistry handshakeRegistry;
    private final PacketRegistry statusRegistry;
    private final PacketRegistry loginRegistry;
    private final PacketRegistry playRegistry;
    private final ReentrantLock lock = new ReentrantLock();

    public ProtocolImpl() {
        handshakeRegistry = new PacketRegistry();
        statusRegistry = new PacketRegistry();
        loginRegistry = new PacketRegistry();
        playRegistry = new PacketRegistry();
        handshakeRegistry.register(0x00, HandshakePacket.class);
        handshakeRegistry.freeze();
        statusRegistry.freeze();
        loginRegistry.freeze();
        playRegistry.freeze();
    }

    public void handleHandshake(PacketBuffer buffer, PacketSession session) throws Exception {
        lock.lock();
        try {
            int packetLength = buffer.readVarInt();
            if (packetLength < 0 || packetLength > 32767) throw new IllegalArgumentException("Invalid packet length: " + packetLength);
            int packetId = buffer.readVarInt();
            PacketRegistry registry = getPacketRegistry(session.getState());
            if (!registryHasPacket(registry, packetId)) throw new IllegalStateException("Unknown handshake packet");
            Packet packet = registry.createPacket(packetId);
            packet.read(buffer);
            if (!(packet instanceof HandshakePacket)) throw new IllegalStateException("Not a handshake packet");
            HandshakePacket handshake = (HandshakePacket) packet;
            int nextState = handshake.nextState;
            switch (nextState) {
                case 1: session.setState(ProtocolState.STATUS); break;
                case 2: session.setState(ProtocolState.LOGIN); break;
                default: throw new IllegalArgumentException("Invalid handshake nextState: " + nextState);
            }
        } catch (Exception e) {
            System.err.println("Handshake error: " + e.getMessage());
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public void processPacket(PacketBuffer buffer, PacketSession session) throws Exception {
        lock.lock();
        try {
            int packetId = buffer.readVarInt();
            PacketRegistry registry = getPacketRegistry(session.getState());
            if (!registryHasPacket(registry, packetId)) throw new IllegalStateException("Unknown packet");
            Packet packet = registry.createPacket(packetId);
            packet.read(buffer);
            // TODO: Implement readableBytes() or equivalent check for remaining bytes in buffer
        } catch (Exception e) {
            System.err.println("Packet processing error: " + e.getMessage());
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public void sendPacket(PacketBuffer buffer, Packet packet, PacketSession session) throws Exception {
        lock.lock();
        try {
            PacketRegistry registry = getPacketRegistry(session.getState());
            int packetId = registry.getPacketId(packet.getClass());
            buffer.writeVarInt(packetId);
            packet.write(buffer);
            buffer.flush();
        } catch (Exception e) {
            System.err.println("Packet send error: " + e.getMessage());
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public int getProtocolVersion() {
        return 210;
    }

    public PacketRegistry getPacketRegistry(ProtocolState state) {
        switch (state) {
            case HANDSHAKE: return handshakeRegistry;
            case STATUS: return statusRegistry;
            case LOGIN: return loginRegistry;
            case PLAY: return playRegistry;
            default: throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

    private boolean registryHasPacket(PacketRegistry registry, int packetId) {
        try {
            registry.createPacket(packetId);
            return true;
        } catch (Exception e) {
            System.err.println("Registry lookup error: " + e.getMessage());
            return false;
        }
    }
}
