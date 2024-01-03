package dev.neuralnexus.taterlib.fabric.event.player;

import dev.neuralnexus.taterlib.event.player.PlayerLogoutEvent;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

/** Fabric implementation of {@link PlayerLogoutEvent}. */
public class FabricPlayerLogoutEvent extends FabricPlayerEvent implements PlayerLogoutEvent {
    private final ServerGamePacketListenerImpl handler;
    private final MinecraftServer server;

    public FabricPlayerLogoutEvent(ServerGamePacketListenerImpl handler, MinecraftServer server) {
        super(handler.player);
        this.handler = handler;
        this.server = server;
    }

    /** {@inheritDoc} */
    @Override
    public String getLogoutMessage() {
        return handler.getPlayer().getName().getString() + " left the game";
    }

    /** {@inheritDoc} */
    @Override
    public void setLogoutMessage(String message) {}
}
