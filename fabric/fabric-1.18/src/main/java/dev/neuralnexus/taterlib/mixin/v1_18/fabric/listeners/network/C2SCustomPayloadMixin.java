/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.mixin.v1_18.fabric.listeners.network;

import dev.neuralnexus.modapi.metadata.Mappings;
import dev.neuralnexus.modapi.metadata.enums.MinecraftVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMCVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMappings;
import dev.neuralnexus.taterapi.entity.player.SimplePlayer;
import dev.neuralnexus.taterapi.event.api.NetworkEvents;
import dev.neuralnexus.taterapi.event.network.impl.C2SCustomPacketEventImpl;
import dev.neuralnexus.taterapi.network.CustomPayloadPacket;

import net.minecraft.network.protocol.game.ServerboundCustomPayloadPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@ReqMappings(Mappings.YARN_INTERMEDIARY)
@ReqMCVersion(min = MinecraftVersion.V18, max = MinecraftVersion.V18_2)
@Mixin(ServerGamePacketListenerImpl.class)
public abstract class C2SCustomPayloadMixin {
    @Shadow
    public abstract ServerPlayer shadow$getPlayer();

    /**
     * Called when a custom payload packet is received from the client.
     *
     * @param packet The packet.
     * @param ci The callback info.
     */
    @Inject(method = "handleCustomPayload", at = @At("HEAD"))
    public void onC2SCustomPacket(ServerboundCustomPayloadPacket packet, CallbackInfo ci) {
        if (this.shadow$getPlayer() == null) return;
        CustomPayloadPacket customPacket = (CustomPayloadPacket) packet;
        SimplePlayer player = (SimplePlayer) this.shadow$getPlayer();
        NetworkEvents.C2S_CUSTOM_PACKET.invoke(new C2SCustomPacketEventImpl(customPacket, player));
    }
}
