/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

import dev.neuralnexus.taterapi.event.player.PlayerEvent;

/** Bukkit implementation of {@link PlayerEvent}. */
public class BukkitPlayerEvent {
    private Player event;

    BukkitPlayerEvent(Player event) {
        this.event = event;
    }

    public BukkitPlayerEvent() {
		// TODO Auto-generated constructor stub
	}

	
    public Player player() {
        return (new BukkitPlayer(event)).player();
    }
}
