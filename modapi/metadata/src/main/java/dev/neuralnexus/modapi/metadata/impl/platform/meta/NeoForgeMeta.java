/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.modapi.metadata.impl.platform.meta;

import dev.neuralnexus.modapi.metadata.Logger;
import dev.neuralnexus.modapi.metadata.MinecraftVersion;
import dev.neuralnexus.modapi.metadata.ModInfo;
import dev.neuralnexus.modapi.metadata.Platform;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.modapi.metadata.impl.logger.Slf4jLogger;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.LoadingModList;

import java.util.List;
import java.util.stream.Collectors;

/** Stores data about the NeoForge platform */
public final class NeoForgeMeta implements Platform.Meta {
    @Override
    public MinecraftVersion minecraftVersion() {
        return MinecraftVersion.of(FMLLoader.versionInfo().mcVersion());
    }

    @Override
    public String loaderVersion() {
        return FMLLoader.versionInfo().fmlVersion();
    }

    @Override
    public String apiVersion() {
        return FMLLoader.versionInfo().neoForgeVersion();
    }

    @Override
    public List<ModInfo> modList() {
        List<net.neoforged.fml.loading.moddiscovery.ModInfo> mods = ModList.get().getMods();
        if (mods == null || mods.isEmpty()) {
            mods = LoadingModList.get().getMods();
        }
        return mods.stream()
                .map(
                        modContainer ->
                                new ModInfoImpl(
                                        modContainer.getModId(),
                                        modContainer.getDisplayName(),
                                        modContainer.getVersion().toString(),
                                        Platforms.NEOFORGE))
                .collect(Collectors.toList());
    }

    @Override
    public Logger logger(String modId) {
        return new Slf4jLogger(modId);
    }
}
