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

@SuppressWarnings("unused")
public class BukkitTaterLibPlugin extends Plugin implements TaterLibPlugin {
	BukkitBlockListener blockBreakListener = new BukkitBlockListener();
	BukkitCommandWrapper commandListener = new BukkitCommandWrapper();
	BukkitEntityListener entityListener = new BukkitEntityListener();
    @Override
    public void enable() {
        // block breaking normal
    	etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, blockBreakListener, this, PluginListener.Priority.MEDIUM);
    	// command
    	etc.getLoader().addListener(PluginLoader.Hook.COMMAND, commandListener, this, PluginListener.Priority.MEDIUM);
    	etc.getLoader().addListener(PluginLoader.Hook.SERVERCOMMAND, commandListener, this, PluginListener.Priority.MEDIUM);
    	// damage normal
    	etc.getLoader().addListener(PluginLoader.Hook.DAMAGE, entityListener, this, PluginListener.Priority.MEDIUM);
    	// death normal
    	//just use that \/
    	//etc.getLoader().addListener(PluginLoader.Hook.HEALTH_CHANGE, entityListener, this, PluginListener.Priority.MEDIUM);
    	// mob spawn normal
    	etc.getLoader().addListener(PluginLoader.Hook.MOB_SPAWN, entityListener, this, PluginListener.Priority.MEDIUM);
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
