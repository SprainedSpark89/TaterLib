/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_13.sponge;

import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.loader.Loader;
import dev.neuralnexus.taterapi.server.SimpleServer;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.v1_13.sponge.listeners.block.SpongeBlockListener;
import dev.neuralnexus.taterlib.v1_13.sponge.listeners.command.SpongeCommandListener;
import dev.neuralnexus.taterlib.v1_13.sponge.listeners.entity.SpongeEntityListener;
import dev.neuralnexus.taterlib.v1_13.sponge.listeners.player.SpongePlayerListener;
import dev.neuralnexus.taterlib.v1_13.sponge.listeners.server.SpongeServerListener;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.plugin.PluginContainer;

public class SpongeTaterLibPlugin implements TaterLibPlugin {
    @Override
    public void onInit() {
        this.onEnable();
        TaterAPIProvider.api(Platforms.SPONGE)
                .ifPresent(api -> api.setServer(() -> (SimpleServer) Sponge.server()));
    }

    @Override
    public void onEnable() {
        if (MetaAPI.instance().isPrimaryPlatform(Platforms.SPONGE)) {
            // Register listeners
            PluginContainer container = (PluginContainer) Loader.instance().plugin();
            EventManager eventManager = Sponge.eventManager();
            eventManager.registerListeners(container, new SpongeBlockListener());
            eventManager.registerListeners(container, new SpongeCommandListener());
            eventManager.registerListeners(container, new SpongeEntityListener());
            eventManager.registerListeners(container, new SpongePlayerListener());
            eventManager.registerListeners(container, new SpongeServerListener());
        }
    }

    @Override
    public void onDisable() {
        this.onDisable();
    }
}
