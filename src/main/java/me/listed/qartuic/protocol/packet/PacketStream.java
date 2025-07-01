package me.listed.qartuic.protocol.packet;

import java.io.InputStream;
import java.io.OutputStream;

public class PacketStream {
    private final InputStream in;
    private final OutputStream out;
    public PacketStream(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    public InputStream getInputStream() {
        return in;
    }
    public OutputStream getOutputStream() {
        return out;
    }
}
