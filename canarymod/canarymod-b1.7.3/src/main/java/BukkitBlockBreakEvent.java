/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.block.PlayerBlockBreakEvent;

/** Bukkit implementation of {@link PlayerBlockBreakEvent}. */
public class BukkitBlockBreakEvent extends BukkitBlockEvent implements PlayerBlockBreakEvent {
    public final Player player;
    public final Block block;
    public boolean cancel = false;

    public BukkitBlockBreakEvent(Player player, Block block) {
        super(player, block);
        this.player = player;
        this.block = block;
    }

    @Override
    public boolean cancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancelled) {
    	this.cancel = cancelled;
    }

    @Override
    public dev.neuralnexus.taterapi.entity.player.Player player() {
        return new BukkitPlayer(player);
    }
}
