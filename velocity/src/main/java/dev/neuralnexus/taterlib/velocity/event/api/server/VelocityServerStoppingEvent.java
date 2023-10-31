package dev.neuralnexus.taterlib.velocity.event.api.server;

import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import dev.neuralnexus.taterlib.common.event.server.ServerStoppingEvent;

/**
 * Velocity implementation of {@link ServerStoppingEvent}.
 */
public class VelocityServerStoppingEvent implements ServerStoppingEvent {
    private final ProxyShutdownEvent event;

    public VelocityServerStoppingEvent(ProxyShutdownEvent event) {
        this.event = event;
    }
}
