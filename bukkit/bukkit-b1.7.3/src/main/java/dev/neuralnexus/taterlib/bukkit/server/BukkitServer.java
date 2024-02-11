package dev.neuralnexus.taterlib.bukkit.server;

import dev.neuralnexus.taterlib.bukkit.player.BukkitPlayer;
import dev.neuralnexus.taterlib.exceptions.VersionFeatureNotSuportedException;
import dev.neuralnexus.taterlib.player.SimplePlayer;
import dev.neuralnexus.taterlib.server.Server;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/** Bukkit implementation of {@link Server}. */
public class BukkitServer implements Server {
    private final org.bukkit.Server server;

    public BukkitServer(org.bukkit.Server server) {
        this.server = server;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return "local";
    }

    /** {@inheritDoc} */
    @Override
    public String getBrand() {
        throw new VersionFeatureNotSuportedException();
    }

    /** {@inheritDoc} */
    @Override
    public Set<SimplePlayer> getOnlinePlayers() {
        return Arrays.stream(server.getOnlinePlayers())
                .map(BukkitPlayer::new)
                .collect(Collectors.toSet());
    }
}
