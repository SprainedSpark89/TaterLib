/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterapi.entity.player;

import dev.neuralnexus.taterapi.TaterAPIProvider;

/** Abstracts a proxy player. */
public interface ProxyPlayer extends SimplePlayer, Connection {
    /**
     * Connect the player to a server.
     *
     * @param serverName The name of the server to connect to.
     */
    void connect(String serverName);

    @Override
    default boolean hasPermission(String permission) {
        return TaterAPIProvider.hasPermission(this, permission);
    }
}
