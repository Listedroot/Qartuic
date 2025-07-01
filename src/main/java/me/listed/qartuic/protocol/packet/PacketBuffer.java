package me.listed.qartuic.protocol.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PacketBuffer {
    private final DataInputStream in;
    private final DataOutputStream out;

    public PacketBuffer(InputStream in, OutputStream out) {
        this.in = new DataInputStream(in);
        this.out = new DataOutputStream(out);
    }

    public int readVarInt() throws IOException {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            read = in.readByte();
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));
            numRead++;
            if (numRead > 5) throw new RuntimeException("VarInt too big");
        } while ((read & 0b10000000) != 0);
        return result;
    }

    public void writeVarInt(int value) throws IOException {
        do {
            byte temp = (byte) (value & 0b01111111);
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            out.writeByte(temp);
        } while (value != 0);
    }

    public String readString() throws IOException {
        int length = readVarInt();
        byte[] bytes = new byte[length];
        in.readFully(bytes);
        return new String(bytes, "UTF-8");
    }

    public void writeString(String value) throws IOException {
        byte[] bytes = value.getBytes("UTF-8");
        writeVarInt(bytes.length);
        out.write(bytes);
    }

    public int readInt() throws IOException {
        return in.readInt();
    }

    public void writeInt(int value) throws IOException {
        out.writeInt(value);
    }

    public short readShort() throws IOException {
        return in.readShort();
    }

    public void writeShort(short value) throws IOException {
        out.writeShort(value);
    }

    public byte readByte() throws IOException {
        return in.readByte();
    }

    public void writeByte(byte value) throws IOException {
        out.writeByte(value);
    }

    public void flush() throws IOException {
        out.flush();
    }
}
