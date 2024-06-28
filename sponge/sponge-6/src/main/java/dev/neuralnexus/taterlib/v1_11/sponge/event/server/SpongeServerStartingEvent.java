/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_11.sponge.event.server;

import dev.neuralnexus.taterlib.event.server.ServerStartingEvent;

import org.spongepowered.api.event.game.state.GameStartingServerEvent;

/** Sponge implementation of {@link ServerStartingEvent}. */
public class SpongeServerStartingEvent extends SpongeServerEvent implements ServerStartingEvent {
    public SpongeServerStartingEvent(GameStartingServerEvent event) {
        super(event);
    }
}
