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
		return false;
	}
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        BlockEvents.PLAYER_BLOCK_BREAK.invoke(new BukkitBlockBreakEvent(event));
    }
}
