/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.velocity.v3_3_0.event.network;

import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;

import dev.neuralnexus.taterlib.event.network.RegisterPluginMessagesEvent;
import dev.neuralnexus.taterlib.velocity.v3_3_0.VelocityTaterLibPlugin;

import java.util.Set;

/** Velocity implementation of {@link RegisterPluginMessagesEvent}. */
public class VelocityRegisterPluginMessagesEvent implements RegisterPluginMessagesEvent {
    /** {@inheritDoc} */
    @Override
    public void registerPluginChannel(String channel) {
        VelocityTaterLibPlugin.proxyServer
                .getChannelRegistrar()
                .register(MinecraftChannelIdentifier.from(channel));
    }

    /** {@inheritDoc} */
    @Override
    public void registerPluginChannels(Set<String> channels) {
        channels.forEach(this::registerPluginChannel);
    }
}
