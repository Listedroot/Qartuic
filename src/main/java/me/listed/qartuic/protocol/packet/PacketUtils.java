package me.listed.qartuic.protocol.packet;

import java.io.InputStream;
import java.io.OutputStream;

public class PacketUtils {
    public static PacketBuffer createBuffer(InputStream in, OutputStream out) {
        return new PacketBuffer(in, out);
    }
}
