/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.player.GameMode;
import dev.neuralnexus.taterapi.entity.player.ServerPlayer;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.Location;

import java.util.UUID;

/** CanaryMod implementation of {@link Player}. */
public class CanaryModPlayer extends CanaryModLivingEntity implements dev.neuralnexus.taterapi.entity.player.Player, ServerPlayer {
    private final Player player;

    /**
     * Constructor.
     *
     * @param player The CanaryMod player.
     */
    public CanaryModPlayer(Player player) {
        super(player);
        this.player = player;
    }

    /**
     * Gets the CanaryMod player
     *
     * @return The CanaryMod player
     */
    public Player player() {
        return player;
    }

    @Override
    public UUID uuid() {
        return null;
    }

    @Override
    public String ipAddress() {
        return player.getIP();
    }

    @Override
    public String name() {
        return player.getName();
    }

    @Override
    public String displayName() {
        return player.getName();
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(message);
    }

    @Override
    public void sendPacket(ResourceKey channel, byte[] data) {
        // TODO: Create some different way to send plugin messages
        throw new VersionFeatureNotSupportedException();
        //        player.sendPluginMessage((Plugin) Loader.instance().plugin(), channel.asString(),
        // data);
    }

    public void sendPluginMessage(Plugin plugin, String channel, byte[] data) {
        throw new VersionFeatureNotSupportedException();
        //        player.sendPluginMessage((Plugin) Loader.instance().plugin(), channel.asString(),
        // data);
    }

    public PlayerInventory inventory2() {
        return (new CanaryModPlayerInventory((PlayerInventory)player.getInventory())).playerInventory;
    }

    @Override
    public int ping() {
        // TODO: Find the field that stores the ping
        //        ((CraftPlayer) player).getHandle().netServerHandler.networkManager.f;
        return -1;
    }

    @Override
    public void kick(String reason) {
        player.kick(reason);
    }

    @Override
    public void setSpawn(Location location, boolean forced) {
        // TODO: Write a module to set bed spawns/respawn points
        throw new VersionFeatureNotSupportedException();
        //        player.setBedSpawnLocation(CanaryModConversions.locationFromPosition(position),
        // forced);
    }

    @Override
    public void allowFlight(boolean allow) {
        // TODO: Write a module to allow flight
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public boolean canFly() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public boolean isFlying() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setFlying(boolean flying) {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public GameMode gameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void setGameMode(GameMode gameMode) {
    }

	@Override
	public dev.neuralnexus.taterapi.item.inventory.PlayerInventory inventory() {
		// TODO Auto-generated method stub
		return null;
	}
}
