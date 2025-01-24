/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.player.PlayerLogoutEvent;

/** Bukkit implementation of {@link PlayerLogoutEvent}. */
public class BukkitPlayerLogoutEvent extends BukkitPlayerEvent {
    private final Player event;

    public BukkitPlayerLogoutEvent(Player event) {
        super();
        this.event = event;
    }

    
    public String logoutMessage() {
    	return event.getName() + " left the game.";
    }

    
    public void setLogoutMessage(String message) {
    }
}
