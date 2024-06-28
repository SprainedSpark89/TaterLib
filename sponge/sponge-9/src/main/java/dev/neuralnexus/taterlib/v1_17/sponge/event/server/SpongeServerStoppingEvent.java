/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_17.sponge.event.server;

import dev.neuralnexus.taterlib.event.server.ServerStoppingEvent;

import org.spongepowered.api.Server;
import org.spongepowered.api.event.lifecycle.StoppingEngineEvent;

/** Sponge implementation of {@link ServerStoppingEvent}. */
public class SpongeServerStoppingEvent extends SpongeServerEvent implements ServerStoppingEvent {
    public SpongeServerStoppingEvent(StoppingEngineEvent<Server> event) {
        super(event);
    }
}
