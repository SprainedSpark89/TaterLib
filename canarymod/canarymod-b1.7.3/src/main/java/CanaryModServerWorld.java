/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

/** CanaryMod implementation of {@link World}. */
public class CanaryModServerWorld extends CanaryModWorld {
    private final World world;

    /**
     * Creates a new world.
     *
     * @param world The CanaryMod world.
     */
    public CanaryModServerWorld(World world) {
        super(world);
        this.world = world;
    }

    /**
     * Gets the CanaryMod world.
     *
     * @return The CanaryMod world.
     */
    public World world() {
        return world;
    }
}
