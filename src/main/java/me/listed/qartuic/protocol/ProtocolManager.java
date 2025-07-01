package me.listed.qartuic.protocol;

import me.listed.qartuic.protocol.version.ProtocolVersion;
import me.listed.qartuic.protocol.version.VersionedProtocol;
import java.util.HashMap;
import java.util.Map;

public class ProtocolManager {
    private final Map<ProtocolVersion, VersionedProtocol> protocols;

    public ProtocolManager() {
        this.protocols = new HashMap<>();
        registerProtocols();
    }

    private void registerProtocols() {
        protocols.put(ProtocolVersion.V1_8_9, new me.listed.qartuic.protocol.v1_8_9.ProtocolImpl());
        protocols.put(ProtocolVersion.V1_9, new me.listed.qartuic.protocol.v1_9.ProtocolImpl());
        protocols.put(ProtocolVersion.V1_10, new me.listed.qartuic.protocol.v1_10.ProtocolImpl());
        protocols.put(ProtocolVersion.V1_11, new me.listed.qartuic.protocol.v1_11.ProtocolImpl());
        protocols.put(ProtocolVersion.V1_12, new me.listed.qartuic.protocol.v1_12.ProtocolImpl());
        protocols.put(ProtocolVersion.V1_21_5, new me.listed.qartuic.protocol.v1_21_5.ProtocolImpl());
    }

    public VersionedProtocol getProtocol(ProtocolVersion version) {
        return protocols.get(version);
    }
}
