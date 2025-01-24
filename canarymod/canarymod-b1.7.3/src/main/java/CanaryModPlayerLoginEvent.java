/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.player.PlayerLoginEvent;

/** CanaryMod implementation of {@link PlayerLoginEvent}. */
public class CanaryModPlayerLoginEvent extends CanaryModPlayerEvent {
    private final Player event;

    public CanaryModPlayerLoginEvent(Player event) {
        super();
        this.event = event;
    }

    
    public String loginMessage() {
        return event.getName() + " joined the game.";
    }

    
    public void setLoginMessage(String message) {
    }
}
