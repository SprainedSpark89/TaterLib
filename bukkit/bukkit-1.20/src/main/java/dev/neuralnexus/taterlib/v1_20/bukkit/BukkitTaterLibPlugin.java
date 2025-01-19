/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_20.bukkit;

import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.event.api.CommandEvents;
import dev.neuralnexus.taterapi.event.api.NetworkEvents;
import dev.neuralnexus.taterapi.event.api.ServerEvents;
import dev.neuralnexus.taterapi.event.server.ServerStartingEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppedEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppingEvent;
import dev.neuralnexus.taterapi.loader.Loader;
import dev.neuralnexus.taterlib.TaterLib;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.bukkit.utils.event.command.BukkitCommandRegisterEvent;
import dev.neuralnexus.taterlib.v1_20.bukkit.command.BukkitCommandWrapper;
import dev.neuralnexus.taterlib.v1_20.bukkit.event.network.BukkitRegisterPacketChannelsEvent;
import dev.neuralnexus.taterlib.v1_20.bukkit.listeners.block.BukkitBlockListener;
import dev.neuralnexus.taterlib.v1_20.bukkit.listeners.entity.BukkitEntityListener;
import dev.neuralnexus.taterlib.v1_20.bukkit.listeners.player.BukkitPlayerListener;
import dev.neuralnexus.taterlib.v1_20.bukkit.listeners.player.PaperPlayerListener;
import dev.neuralnexus.taterlib.v1_20.bukkit.listeners.server.BukkitServerListener;
import dev.neuralnexus.taterlib.v1_20.bukkit.server.BukkitServer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

@SuppressWarnings("unused")
public class BukkitTaterLibPlugin implements TaterLibPlugin {
    @Override
    public void onInit() {
        TaterAPIProvider.api(Platforms.BUKKIT)
                .ifPresent(api -> api.setServer(BukkitServer::instance));
    }

    @Override
    public void onEnable() {
        TaterLib.start();
        if (MetaAPI.instance().isPrimaryPlatform(Platforms.BUKKIT)) {
            ServerEvents.STARTING.invoke(new ServerStartingEvent() {});

            // Register listeners
            Plugin plugin = (Plugin) Loader.instance().plugin();
            PluginManager pluginManager = Bukkit.getServer().getPluginManager();
            pluginManager.registerEvents(new BukkitBlockListener(), plugin);
            pluginManager.registerEvents(new BukkitEntityListener(), plugin);
            pluginManager.registerEvents(new BukkitPlayerListener(), plugin);
            if (MetaAPI.instance().isPlatformPresent(Platforms.PAPER)) {
                pluginManager.registerEvents(new PaperPlayerListener(), plugin);
            }
            pluginManager.registerEvents(new BukkitServerListener(), plugin);
            ServerEvents.STARTED.register(
                    event -> {
                        // Register commands
                        CommandEvents.REGISTER_COMMAND.invoke(
                                new BukkitCommandRegisterEvent(BukkitCommandWrapper::new));

                        // Register plugin messages
                        NetworkEvents.REGISTER_CHANNELS.invoke(
                                new BukkitRegisterPacketChannelsEvent());
                    });
        }
    }

    @Override
    public void onDisable() {
        // Run server stopping events
        ServerEvents.STOPPING.invoke(new ServerStoppingEvent() {});
        ServerEvents.STOPPED.invoke(new ServerStoppedEvent() {});
        TaterLib.stop();
    }
}
