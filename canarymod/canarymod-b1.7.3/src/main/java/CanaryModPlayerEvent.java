/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

import dev.neuralnexus.taterapi.event.player.PlayerEvent;

/** CanaryMod implementation of {@link PlayerEvent}. */
public class CanaryModPlayerEvent {
    private Player event;

    CanaryModPlayerEvent(Player event) {
        this.event = event;
    }

    public CanaryModPlayerEvent() {
		// TODO Auto-generated constructor stub
	}

	
    public Player player() {
        return (new CanaryModPlayer(event)).player();
    }
}
