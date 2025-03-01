/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.mixin.v1_16.vanilla.listeners.player;

import dev.neuralnexus.modapi.metadata.Mappings;
import dev.neuralnexus.modapi.metadata.enums.MinecraftVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMCVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMappings;
import dev.neuralnexus.taterapi.event.api.PlayerEvents;
import dev.neuralnexus.taterlib.v1_16.vanilla.event.player.VanillaPlayerLogoutEvent;

import net.minecraft.network.chat.Component;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for the player logout listener. */
@ReqMappings(Mappings.MOJANG)
@ReqMCVersion(min = MinecraftVersion.V16, max = MinecraftVersion.V16_5)
@Mixin(ServerGamePacketListenerImpl.class)
@SuppressWarnings({"unused", "UnusedMixin"})
public class PlayerLogoutMixin {
    /** Called when a player disconnects. */
    @Inject(method = "onDisconnect", at = @At("HEAD"))
    private void onLogout(Component reason, CallbackInfo ci) {
        PlayerEvents.LOGOUT.invoke(
                new VanillaPlayerLogoutEvent(
                        ((ServerGamePacketListenerImpl) (Object) this).player));
    }
}
