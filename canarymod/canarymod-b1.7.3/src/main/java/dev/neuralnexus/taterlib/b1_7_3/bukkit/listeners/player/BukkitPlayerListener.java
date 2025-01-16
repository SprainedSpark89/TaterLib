/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.b1_7_3.bukkit.listeners.player;

import dev.neuralnexus.taterapi.event.api.PlayerEvents;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.player.BukkitPlayerLoginEvent;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.player.BukkitPlayerLogoutEvent;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.player.BukkitPlayerMessageEvent;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.player.BukkitPlayerRespawnEvent;

import org.bukkit.event.player.*;

/** Listens for player events. */
public class BukkitPlayerListener extends PlayerListener {
    /**
     * Called when a player logs in.
     *
     * @param event The event.
     */
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        PlayerEvents.LOGIN.invoke(new BukkitPlayerLoginEvent(event));
    }

    /**
     * Called when a player logs out.
     *
     * @param event The event.
     */
    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        PlayerEvents.LOGOUT.invoke(new BukkitPlayerLogoutEvent(event));
    }

    /**
     * Called when a player sends a message.
     *
     * @param event The event.
     */
    @Override
    public void onPlayerChat(PlayerChatEvent event) {
        PlayerEvents.MESSAGE.invoke(new BukkitPlayerMessageEvent(event));
    }

    /**
     * Called when a player respawns.
     *
     * @param event The event.
     */
    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        PlayerEvents.RESPAWN.invoke(new BukkitPlayerRespawnEvent(event));
    }
}
