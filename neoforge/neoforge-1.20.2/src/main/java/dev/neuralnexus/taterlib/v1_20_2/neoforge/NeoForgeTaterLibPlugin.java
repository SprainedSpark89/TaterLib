/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_20_2.neoforge;

import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.v1_20.vanilla.VanillaBootstrap;

import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

public class NeoForgeTaterLibPlugin implements TaterLibPlugin {
    @Override
    public void onInit() {
        VanillaBootstrap.init();
        this.onEnable();
        TaterAPIProvider.setSide(VanillaBootstrap.determineSide(FMLEnvironment.dist.isClient()));
        TaterAPIProvider.api(Platforms.NEOFORGE)
                .ifPresent(
                        api ->
                                api.setServer(
                                        VanillaBootstrap.server(
                                                ServerLifecycleHooks::getCurrentServer)));
    }
}
