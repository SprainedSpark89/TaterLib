/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.player.SimplePlayer;
import dev.neuralnexus.taterapi.event.player.PlayerMessageEvent;

import java.util.Set;

/** CanaryMod implementation of {@link PlayerMessageEvent}. */
public class CanaryModPlayerMessageEvent extends CanaryModPlayerEvent {
    private Player event;
    private String message;
    public boolean cancel = false;

    public CanaryModPlayerMessageEvent(Player event, String message) {
        this.event = event;
    }

    
    public boolean cancelled() {
        return cancel;
    }

    
    public void setCancelled(boolean cancelled) {
        cancel = (cancelled);
    }

    
    public String message() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = (message);
    }

    
    public Player recipient() {
        return event;
    }

    
    public void setRecipients(Player recipients) {
        event = recipients;
    }

	
	public void setRecipients(Set<SimplePlayer> recipients) {
		// TODO Auto-generated method stub
		
	}

	
	public Set<SimplePlayer> recipients() {
		// TODO Auto-generated method stub
		return null;
	}
}
