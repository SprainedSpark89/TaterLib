package dev.neuralnexus.taterlib.sponge.abstractions.player;

import dev.neuralnexus.taterlib.common.abstractions.player.AbstractPlayer;
import dev.neuralnexus.taterlib.common.abstractions.player.AbstractPlayerInventory;
import dev.neuralnexus.taterlib.common.abstractions.utils.Position;
import dev.neuralnexus.taterlib.sponge.SpongeTaterLibPlugin;
import dev.neuralnexus.taterlib.sponge.abstractions.util.SpongeConversions;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.network.ChannelBinding;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.text.Text;

import java.util.UUID;

/**
 * Abstracts a Sponge player to an AbstractPlayer.
 */
public class SpongePlayer implements AbstractPlayer {
    private final Player player;
    private String serverName;

    /**
     * Constructor.
     * @param player The Sponge player.
     */
    public SpongePlayer(Player player) {
        this.player = player;
        this.serverName = "local";
    }

    /**
     * Constructor.
     * @param player The Sponge player.
     * @param serverName The name of the server the player is on.
     */
    public SpongePlayer(Player player, String serverName) {
        this.player = player;
        this.serverName = serverName;
    }

    /**
     * Gets the Sponge player
     * @return The Sponge player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @inheritDoc
     */
    @Override
    public UUID getUUID() {
        return player.getUniqueId();
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getName() {
        return player.getName();
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getDisplayName() {
        return player.getDisplayNameData().displayName().get().toPlain();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Position getPosition() {
        return SpongeConversions.positionFromVector(player.getLocation().getPosition());
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getServerName() {
        return serverName;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void sendMessage(String message) {
        player.sendMessage(Text.of(message));
    }

    /**
     * @inheritDoc
     */
    @Override
    public void sendPluginMessage(String channel, byte[] data) {
        ChannelRegistrar channelRegistrar = Sponge.getChannelRegistrar();
        ChannelBinding.RawDataChannel channelBinding = channelRegistrar.getOrCreateRaw(SpongeTaterLibPlugin.getInstance(), channel);
        channelBinding.sendTo(player, (buffer) -> buffer.writeBytes(data));
    }

    /**
     * @inheritDoc
     */
    @Override
    public AbstractPlayerInventory getInventory() {
        return new SpongePlayerInventory(player.getInventory().first());
    }

    /**
     * @inheritDoc
     */
    @Override
    public void kickPlayer(String message) {
        player.kick(Text.of(message));
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setSpawn(Position position) {}

    /**
     * @inheritDoc
     */
    @Override
    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }
}
