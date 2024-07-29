/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.mixin.v1_15.vanilla.listeners.server;

import dev.neuralnexus.conditionalmixins.annotations.ReqMCVersion;
import dev.neuralnexus.conditionalmixins.annotations.ReqPlatform;
import dev.neuralnexus.taterapi.MinecraftVersion;
import dev.neuralnexus.taterapi.Platform;
import dev.neuralnexus.taterapi.event.api.ServerEvents;
import dev.neuralnexus.taterapi.event.server.impl.ServerStoppedEventImpl;

import net.minecraft.server.MinecraftServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for the server stopped listener. */
@ReqPlatform(not = Platform.FORGE)
@ReqMCVersion(min = MinecraftVersion.V1_15, max = MinecraftVersion.V1_15_2)
@Mixin(MinecraftServer.class)
public class ServerStoppedMixin {
    /** Called when the server has stopped. */
    @Inject(at = @At("TAIL"), method = "stopServer")
    private void onServerStopped(CallbackInfo info) {
        ServerEvents.STOPPED.invoke(new ServerStoppedEventImpl());
    }
}
