# Qartuic 

Qartuic is a Java library for building Minecraft server software foundation. It provides protocol support for every Minecraft version from 1.8.9 to 1.21.5. Qartuic is intended for server developers who want to implement the Minecraft protocol themselves, not for plugin or wrapper development. All protocol logic follows the official Minecraft specifications for the best stable experience.

---

## Why use Qartuic?
- Handles handshake, status, login, and play phases for each supported version.
- Strongly-typed packet classes—no need to parse raw bytes yourself.
- Packet registries are immutable and thread-safe after setup.
- Each connection tracks its state using a `PacketSession`.
- Errors are always logged or thrown—never ignored.
- Used as a base for new server projects, not for plugins.

---

## Features

- Implements handshake, status, login, and play phases for all Minecraft versions 1.8.9–1.21.5, verified against the Mojang protocol specs.
- Unified `VersionedProtocol` interface for every version, with separate, real implementations.
- Strongly-typed packet classes for all protocol states—no manual parsing needed.
- Immutable, thread-safe packet registries.
- Per-connection state tracking with `PacketSession`.
- Robust validation to prevent malformed packet crashes.
- All errors are logged or propagated—no silent failures.
- Utilities for VarInt, string, and buffer handling.
- Designed for resource and thread safety.
- Encryption/compression hooks are planned, not yet implemented.

- **Immutable Packet Registries:** Thread-safe, immutable packet registries after initialization.
- **Per-Connection State Tracking:** Every connection managed via a `PacketSession` object.
- **Robust Validation:** All packets are validated for length and structure to prevent malformed packet crashes.
- **Explicit Error Handling:** All errors are logged and propagated—no silent failures.
- **Thread Safety:** Uses locks for safe concurrent packet handling.
- **Buffering Helpers:** Utilities for VarInt, string, and packet buffer manipulation.
- **Resource Safety:** Designed for safe stream and socket handling.
- **Encryption & Compression:** (Planned) Layer hooks for protocol encryption and compression.

## Getting Started

### Requirements
- Java 17+
- Maven (for build)

### Installation (JitPack)
Add to your `pom.xml`:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependency>
    <groupId>com.github.Listedroot</groupId>
    <artifactId>Qartuic</artifactId>
    <version>RELEASE_TAG</version>
</dependency>
```

### Example: Creating a Protocol Session
```java
import me.listed.qartuic.protocol.version.VersionedProtocol;
import me.listed.qartuic.protocol.packet.PacketSession;
import me.listed.qartuic.protocol.ProtocolState;

VersionedProtocol protocol = ...; // e.g., new ProtocolImpl() for a version
PacketSession session = new PacketSession();
session.setState(ProtocolState.HANDSHAKE);
// Use protocol.handleHandshake(buffer, session), etc.
```

### Example: Registering and Using Packets
```java
PacketRegistry registry = protocol.getPacketRegistry(ProtocolState.PLAY);
Packet packet = registry.createPacket(0x01); // Create by packet ID
packet.read(buffer);
```

## FAQ

### Q: What Minecraft versions are supported?
A: All versions from 1.8.9 through 1.21.5, each with a dedicated protocol implementation.

### Q: Is this library suitable for plugin development?
A: No. Qartuic is for server software developers, not plugin authors.

### Q: How do I add support for a new protocol version?
A: Implement the `VersionedProtocol` interface and follow the structure in `me.listed.qartuic.protocol.v1_xx.ProtocolImpl`.

### Q: How are packets validated?
A: All packets are length-checked and validated for structure. Malformed packets throw explicit errors.

### Q: Is encryption/compression supported?
A: Hooks are planned; see CONTRIBUTING.md for details on helping with this feature.

### Q: Is the packet registry thread-safe?
A: Yes. Registries are immutable after initialization.

## Contributing
See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License
MIT License. See [LICENSE](LICENSE).
