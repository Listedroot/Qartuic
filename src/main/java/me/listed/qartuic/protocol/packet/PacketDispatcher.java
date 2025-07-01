package me.listed.qartuic.protocol.packet;

public class PacketDispatcher {
    private final PacketHandler handler;
    public PacketDispatcher(PacketHandler handler) {
        this.handler = handler;
    }
    public void dispatch(PacketContext context) throws Exception {
        handler.handle(context.packet);
    }
}
