/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_15.forge;

import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.v1_15.forge.listeners.block.ForgeBlockListener;
import dev.neuralnexus.taterlib.v1_15.forge.listeners.command.ForgeCommandsListener;
import dev.neuralnexus.taterlib.v1_15.forge.listeners.entity.ForgeEntityListener;
import dev.neuralnexus.taterlib.v1_15.forge.listeners.player.ForgePlayerListener;
import dev.neuralnexus.taterlib.v1_15.forge.listeners.server.ForgeServerListener;
import dev.neuralnexus.taterlib.v1_15.vanilla.VanillaBootstrap;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

@SuppressWarnings("unused")
public class ForgeTaterLibPlugin implements TaterLibPlugin {
    @Override
    public void onInit() {
        VanillaBootstrap.init();
        this.onEnable();
        TaterAPIProvider.setSide(VanillaBootstrap.determineSide(FMLEnvironment.dist.isClient()));
        TaterAPIProvider.api(Platforms.FORGE)
                .ifPresent(
                        api ->
                                api.setServer(
                                        VanillaBootstrap.server(
                                                ServerLifecycleHooks::getCurrentServer)));

        if (MetaAPI.instance().isPrimaryPlatform(Platforms.FORGE)) {
            // Register listeners
            MinecraftForge.EVENT_BUS.register(this);
            MinecraftForge.EVENT_BUS.register(new ForgeBlockListener());
            MinecraftForge.EVENT_BUS.register(new ForgeCommandsListener());
            MinecraftForge.EVENT_BUS.register(new ForgeEntityListener());
            MinecraftForge.EVENT_BUS.register(new ForgePlayerListener());
            MinecraftForge.EVENT_BUS.register(new ForgeServerListener());
        }
    }

    /**
     * Called when the server is stopping.
     *
     * @param event The event.
     */
    @SubscribeEvent
    public void onServerStopped(FMLServerStoppedEvent event) {
        this.onDisable();
    }
}
