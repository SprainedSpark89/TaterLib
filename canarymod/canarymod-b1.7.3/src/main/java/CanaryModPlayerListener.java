/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.api.PlayerEvents;

/** Listens for player events. */
public class CanaryModPlayerListener extends PluginListener {
    /**
     * Called when a player logs in.
     *
     * @param event The event.
     */
	public void onLogin(Player player) {
		PlayerEvents.LOGIN.invoke(new CanaryModPlayerLoginEvent(player));
    }

    /**
     * Called when a player logs out.
     *
     * @param event The event.
     */
    public void onDisconnect(Player player) {
    	PlayerEvents.LOGOUT.invoke(new CanaryModPlayerLogoutEvent(player));
    }

    /**
     * Called when a player sends a message.
     *
     * @param event The event.
     */
    
    public boolean onChat(Player player, String message) {
    	PlayerEvents.MESSAGE.invoke(new CanaryModPlayerMessageEvent(player, message));
        return false;
    }

    /**
     * Called when a player respawns.
     *
     * @param event The event.
     */
}
