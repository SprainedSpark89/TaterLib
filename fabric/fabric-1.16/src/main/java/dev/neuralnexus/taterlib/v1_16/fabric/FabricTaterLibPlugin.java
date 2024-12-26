/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_16.fabric;

import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.event.api.*;
import dev.neuralnexus.taterapi.event.server.ServerStartedEvent;
import dev.neuralnexus.taterapi.event.server.ServerStartingEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppedEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppingEvent;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.v1_16.fabric.hooks.permissions.FabricPermissionsHook;
import dev.neuralnexus.taterlib.v1_16.vanilla.VanillaBootstrap;
import dev.neuralnexus.taterlib.v1_16.vanilla.event.command.VanillaBrigadierCommandRegisterEvent;
import dev.neuralnexus.taterlib.v1_16.vanilla.event.command.VanillaCommandRegisterEvent;
import dev.neuralnexus.taterlib.v1_16.vanilla.event.player.VanillaPlayerLoginEvent;
import dev.neuralnexus.taterlib.v1_16.vanilla.event.player.VanillaPlayerLogoutEvent;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;

@SuppressWarnings("unused")
public class FabricTaterLibPlugin implements TaterLibPlugin {
    private static MinecraftServer server;

    @Override
    public void onInit() {
        VanillaBootstrap.init();
        TaterAPIProvider.addHook(new FabricPermissionsHook());
        start();
        TaterAPIProvider.setSide(
                VanillaBootstrap.determineSide(
                        FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT));
        TaterAPIProvider.api(Platform.FABRIC)
                .ifPresent(api -> api.setServer(VanillaBootstrap.server(() -> server)));

        if (MetaAPI.instance().isPrimaryPlatform(Platform.FABRIC)) {
            // Initialize plugin data
            ServerLifecycleEvents.SERVER_STARTING.register(s -> server = s);
            ServerLifecycleEvents.SERVER_STOPPED.register(s -> stop());

            // Register Fabric API command events
            CommandRegistrationCallback.EVENT.register(
                    (dispatcher, dedicated) -> {
                        Commands.CommandSelection environment =
                                dedicated
                                        ? Commands.CommandSelection.DEDICATED
                                        : Commands.CommandSelection.INTEGRATED;
                        CommandEvents.REGISTER_COMMAND.invoke(
                                new VanillaCommandRegisterEvent(dispatcher, environment));
                        CommandEvents.REGISTER_BRIGADIER_COMMAND.invoke(
                                new VanillaBrigadierCommandRegisterEvent(dispatcher, environment));
                    });

            // Register Fabric API player events
            ServerPlayConnectionEvents.JOIN.register(
                    (handler, sender, s) ->
                            PlayerEvents.LOGIN.invoke(new VanillaPlayerLoginEvent(handler.player)));
            ServerPlayConnectionEvents.DISCONNECT.register(
                    (handler, s) ->
                            PlayerEvents.LOGOUT.invoke(
                                    new VanillaPlayerLogoutEvent(handler.player)));

            // Register Fabric API server events
            ServerLifecycleEvents.SERVER_STARTING.register(
                    s -> ServerEvents.STARTING.invoke(new ServerStartingEvent() {}));
            ServerLifecycleEvents.SERVER_STARTED.register(
                    s -> ServerEvents.STARTED.invoke(new ServerStartedEvent() {}));
            ServerLifecycleEvents.SERVER_STOPPING.register(
                    s -> ServerEvents.STOPPING.invoke(new ServerStoppingEvent() {}));
            ServerLifecycleEvents.SERVER_STOPPED.register(
                    s -> ServerEvents.STOPPED.invoke(new ServerStoppedEvent() {}));
        }
    }
}
