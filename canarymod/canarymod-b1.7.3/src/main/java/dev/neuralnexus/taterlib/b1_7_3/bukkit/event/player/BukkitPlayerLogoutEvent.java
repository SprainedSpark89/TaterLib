/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.b1_7_3.bukkit.event.player;

import dev.neuralnexus.taterapi.event.player.PlayerLogoutEvent;

import org.bukkit.event.player.PlayerQuitEvent;

/** Bukkit implementation of {@link PlayerLogoutEvent}. */
public class BukkitPlayerLogoutEvent extends BukkitPlayerEvent implements PlayerLogoutEvent {
    private final PlayerQuitEvent event;

    public BukkitPlayerLogoutEvent(PlayerQuitEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String logoutMessage() {
        return event.getQuitMessage();
    }

    @Override
    public void setLogoutMessage(String message) {
        event.setQuitMessage(message);
    }
}
