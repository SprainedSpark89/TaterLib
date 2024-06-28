/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_8.bungee.server;

import dev.neuralnexus.taterlib.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterlib.player.SimplePlayer;
import dev.neuralnexus.taterlib.server.Server;
import dev.neuralnexus.taterlib.v1_8.bungee.player.BungeePlayer;
import dev.neuralnexus.taterlib.world.ServerWorld;

import net.md_5.bungee.api.config.ServerInfo;

import java.util.List;
import java.util.stream.Collectors;

/** Bungee implementation of {@link Server}. */
public class BungeeServer implements Server {
    private final ServerInfo server;

    public BungeeServer(ServerInfo server) {
        this.server = server;
    }

    /** {@inheritDoc} */
    @Override
    public String name() {
        return server.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String brand() {
        // TODO: Pass this information up through plugin messages as a way to sync the server brand
        throw new VersionFeatureNotSupportedException();
    }

    /** {@inheritDoc} */
    @Override
    public List<SimplePlayer> onlinePlayers() {
        return server.getPlayers().stream().map(BungeePlayer::new).collect(Collectors.toList());
    }

    /** {@inheritDoc} */
    @Override
    public List<ServerWorld> worlds() {
        throw new VersionFeatureNotSupportedException();
    }
}
