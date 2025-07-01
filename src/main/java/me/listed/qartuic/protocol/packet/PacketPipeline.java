package me.listed.qartuic.protocol.packet;

import java.io.InputStream;
import java.io.OutputStream;

public class PacketPipeline {
    private final PacketBuffer buffer;
    public PacketPipeline(InputStream in, OutputStream out) {
        this.buffer = new PacketBuffer(in, out);
    }
    public PacketBuffer getBuffer() {
        return buffer;
    }
}
