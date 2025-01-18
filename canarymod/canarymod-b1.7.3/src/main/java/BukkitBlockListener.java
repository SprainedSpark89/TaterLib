/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.api.BlockEvents;

/** Listens for world events. */
public class BukkitBlockListener extends PluginListener {
    /**
     * Called when a block is broken.
     *
     * @param event The event.
     */
	public boolean onBlockBreak(final Player player, final Block block) {
		BlockEvents.PLAYER_BLOCK_BREAK.invoke(new BukkitBlockBreakEvent(player, block));
		return ((BukkitBlockBreakEvent)(BlockEvents.PLAYER_BLOCK_BREAK.listeners().get(0))).cancel;
	}
}
