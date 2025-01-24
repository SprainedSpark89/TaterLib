/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.player.PlayerLogoutEvent;

/** CanaryMod implementation of {@link PlayerLogoutEvent}. */
public class CanaryModPlayerLogoutEvent extends CanaryModPlayerEvent {
    private final Player event;

    public CanaryModPlayerLogoutEvent(Player event) {
        super();
        this.event = event;
    }

    
    public String logoutMessage() {
    	return event.getName() + " left the game.";
    }

    
    public void setLogoutMessage(String message) {
    }
}
