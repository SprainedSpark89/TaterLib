/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_12_2.bungee.event.server;

import dev.neuralnexus.taterapi.event.server.ServerEvent;
import dev.neuralnexus.taterapi.server.ProxyServer;
import dev.neuralnexus.taterlib.v1_12_2.bungee.server.BungeeProxyServer;

/** Bungee implementation of {@link ServerEvent}. */
public class BungeeServerEvent implements ServerEvent {
    /** {@inheritDoc} */
    @Override
    public ProxyServer server() {
        return BungeeProxyServer.instance();
    }
}
