/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_20.sponge;

import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.loader.Loader;
import dev.neuralnexus.taterapi.server.SimpleServer;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.v1_20.sponge.listeners.command.SpongeCommandListener;

import org.spongepowered.api.Sponge;
import org.spongepowered.plugin.PluginContainer;

public class SpongeTaterLibPlugin implements TaterLibPlugin {
    private PluginContainer container;

    @Override
    public void onInit() {
        container = (PluginContainer) Loader.instance().plugin();
        this.onEnable();
        TaterAPIProvider.api(Platforms.SPONGE)
                .ifPresent(api -> api.setServer(() -> (SimpleServer) Sponge.server()));
    }

    @Override
    public void onEnable() {
        if (MetaAPI.instance().isPrimaryPlatform(Platforms.SPONGE)) {
            Sponge.eventManager().registerListeners(container, new SpongeCommandListener());
        }
    }

    @Override
    public void onDisable() {
        this.onDisable();
    }
}
