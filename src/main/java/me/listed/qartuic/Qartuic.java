package me.listed.qartuic;

import me.listed.qartuic.protocol.ProtocolManager;
import me.listed.qartuic.protocol.version.ProtocolVersion;
import me.listed.qartuic.protocol.version.VersionedProtocol;
import me.listed.qartuic.protocol.packet.PacketRegistry;
import me.listed.qartuic.protocol.ProtocolState;
import me.listed.qartuic.protocol.packet.PacketBuffer;

public class Qartuic {
    private final ProtocolManager protocolManager;

    public Qartuic() {
        this.protocolManager = new ProtocolManager();
    }

    public VersionedProtocol getProtocol(ProtocolVersion version) {
        return protocolManager.getProtocol(version);
    }

    public ProtocolVersion[] getSupportedVersions() {
        return ProtocolVersion.values();
    }

    public PacketRegistry getPacketRegistry(ProtocolVersion version, ProtocolState state) {
        VersionedProtocol protocol = getProtocol(version);
        if (protocol == null) throw new IllegalArgumentException("Unsupported version");
        return protocol.getPacketRegistry(state);
    }

    public PacketBuffer createBuffer(java.io.InputStream in, java.io.OutputStream out) {
        return new PacketBuffer(in, out);
    }
}
