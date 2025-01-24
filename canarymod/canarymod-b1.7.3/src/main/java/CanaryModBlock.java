/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */



import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.BlockPos;

/** CanaryMod implementation of {@link Block}. */
public class CanaryModBlock implements dev.neuralnexus.taterapi.block.Block {
    public final Block block;

    public CanaryModBlock(Block block) {
        this.block = block;
    }

    @Override
    public ResourceKey type() {
        return ResourceKey.of("minecraft", block.blockType.name());
    }

    @Override
    public BlockPos blockPos() {
        return new BlockPos(block.getX(), block.getY(), block.getZ());
    }
}
