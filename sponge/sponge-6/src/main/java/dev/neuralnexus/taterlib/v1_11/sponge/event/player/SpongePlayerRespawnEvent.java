/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_11.sponge.event.player;

import dev.neuralnexus.taterapi.event.player.PlayerRespawnEvent;
import dev.neuralnexus.taterapi.player.Player;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.v1_11.sponge.player.SpongePlayer;
import dev.neuralnexus.taterlib.v1_11.sponge.world.SpongeLocation;

import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;

/** Sponge implementation of {@link PlayerRespawnEvent}. */
public class SpongePlayerRespawnEvent implements PlayerRespawnEvent {
    private final RespawnPlayerEvent event;

    public SpongePlayerRespawnEvent(RespawnPlayerEvent event) {
        this.event = event;
    }

    /** {@inheritDoc} */
    @Override
    public Player player() {
        return new SpongePlayer(event.getTargetEntity());
    }

    /** {@inheritDoc} */
    @Override
    public Location respawnLocation() {
        return new SpongeLocation(event.getTargetEntity().getLocation());
    }

    /** {@inheritDoc} */
    @Override
    public boolean isBedSpawn() {
        return event.isBedSpawn();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAnchorSpawn() {
        return false;
    }
}
