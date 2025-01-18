/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.event.api.CommandEvents;
import dev.neuralnexus.taterapi.event.api.ServerEvents;
import dev.neuralnexus.taterapi.event.server.ServerStartedEvent;
import dev.neuralnexus.taterapi.event.server.ServerStartingEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppedEvent;
import dev.neuralnexus.taterapi.event.server.ServerStoppingEvent;
import dev.neuralnexus.taterapi.loader.Loader;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.command.BukkitCommandRegisterEvent;

@SuppressWarnings("unused")
public class BukkitTaterLibPlugin extends Plugin implements TaterLibPlugin {
	BukkitBlockListener blockBreakListener = new BukkitBlockListener();
    @Override
    public void enable() {
        // block breaking normal
    	etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, blockBreakListener, this, PluginListener.Priority.MEDIUM);
    	// command
    	// damage normal
    	// death normal
    	// mob spawn normal
    	// player join normal
    	// player leave normal
    	// player chat highest
    	// player respawn normal
    }

    @Override
    public void disable() {
        // Run server stopping events
        ServerEvents.STOPPING.invoke(new ServerStoppingEvent() {});
        ServerEvents.STOPPED.invoke(new ServerStoppedEvent() {});
        this.onDisable();
    }
}
