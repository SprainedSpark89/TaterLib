/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package net.neoforged.neoforge.server;

import net.minecraft.server.MinecraftServer;

/** Fake NeoForge lifecycle hooks. */
public class ServerLifecycleHooks {
    public static MinecraftServer getCurrentServer() {
        return null;
    }
}
