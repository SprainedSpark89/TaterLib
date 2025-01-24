/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.player.PlayerLoginEvent;

/** Bukkit implementation of {@link PlayerLoginEvent}. */
public class BukkitPlayerLoginEvent extends BukkitPlayerEvent {
    private final Player event;

    public BukkitPlayerLoginEvent(Player event) {
        super();
        this.event = event;
    }

    
    public String loginMessage() {
        return event.getName() + " joined the game.";
    }

    
    public void setLoginMessage(String message) {
    }
}
