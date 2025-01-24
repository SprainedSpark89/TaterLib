/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.block.BlockEvent;

/** CanaryMod implementation of {@link BlockEvent}. */
public class CanaryModBlockEvent implements BlockEvent {
	public final Player player;
    public final Block block;

    public CanaryModBlockEvent(Player player, Block block) {
        this.player = player;
        this.block = block;
    }

    @Override
    public dev.neuralnexus.taterapi.block.Block block() {
        return new CanaryModBlock(block);
    }
}
