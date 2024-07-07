/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_11.sponge;

import dev.neuralnexus.taterapi.Platform;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.event.api.CommandEvents;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.loader.Loader;
import dev.neuralnexus.taterlib.v1_11.sponge.event.command.SpongeCommandRegisterEvent;
import dev.neuralnexus.taterlib.v1_11.sponge.hooks.permissions.SpongePermissionsHook;
import dev.neuralnexus.taterlib.v1_11.sponge.listeners.block.SpongeBlockListener;
import dev.neuralnexus.taterlib.v1_11.sponge.listeners.entity.SpongeEntityListener;
import dev.neuralnexus.taterlib.v1_11.sponge.listeners.player.SpongePlayerListener;
import dev.neuralnexus.taterlib.v1_11.sponge.listeners.server.SpongeServerListener;
import dev.neuralnexus.taterlib.v1_11.sponge.server.SpongeServer;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.concurrent.TimeUnit;

public class SpongeTaterLibPlugin implements TaterLibPlugin {
    @Override
    public void onInit() {
        TaterAPIProvider.addHook(new SpongePermissionsHook());
        start();
        TaterAPIProvider.api(Platform.SPONGE)
                .ifPresent(api -> api.setServer(() -> new SpongeServer(Sponge.getServer())));
    }

    @Override
    public void onEnable() {
        if (TaterAPIProvider.isPrimaryPlatform(Platform.SPONGE)) {
            // Register listeners
            PluginContainer container = (PluginContainer) Loader.instance().plugin();
            EventManager eventManager = Sponge.getEventManager();
            eventManager.registerListeners(container, new SpongeBlockListener());
            Sponge.getScheduler()
                    .createTaskBuilder()
                    .delay(10, TimeUnit.SECONDS)
                    .execute(
                            () ->
                                    CommandEvents.REGISTER_COMMAND.invoke(
                                            new SpongeCommandRegisterEvent()))
                    .submit(container);
            eventManager.registerListeners(container, new SpongeEntityListener());
            eventManager.registerListeners(container, new SpongePlayerListener());
            eventManager.registerListeners(container, new SpongeServerListener());
        }
    }

    @Override
    public void onDisable() {
        stop();
    }
}
