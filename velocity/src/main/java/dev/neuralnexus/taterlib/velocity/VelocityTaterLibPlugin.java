package dev.neuralnexus.taterlib.velocity;

import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Dependency;
import dev.neuralnexus.taterlib.common.TaterLib;
import dev.neuralnexus.taterlib.common.TaterLibPlugin;
import dev.neuralnexus.taterlib.common.abstractions.logger.AbstractLogger;
import dev.neuralnexus.taterlib.common.commands.TaterLibCommand;
import dev.neuralnexus.taterlib.common.hooks.LuckPermsHook;
import dev.neuralnexus.taterlib.common.listeners.server.ServerListener;
import dev.neuralnexus.taterlib.velocity.abstractions.logger.VelocityLogger;
import dev.neuralnexus.taterlib.velocity.commands.VelocityTaterLibCommand;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.neuralnexus.taterlib.velocity.listeners.player.VelocityPlayerListener;
import dev.neuralnexus.taterlib.velocity.listeners.server.VelocityServerListener;
import org.slf4j.Logger;

/**
 * The TaterLib Velocity plugin.
 */
@Plugin(
        id = "taterlib",
        name = "TaterLib",
        version = "1.0.0",
        authors = "p0t4t0sandwich",
        description = "A cross API code library for various generalizations used in the Tater* plugins",
        url = "https://github.com/p0t4t0sandwich/TaterLib",
        dependencies = {
                @Dependency(id = "luckperms", optional = true)
        }
)
public class VelocityTaterLibPlugin extends TemplateVelocityPlugin implements TaterLibPlugin {
    @Inject private ProxyServer server;
    @Inject private Logger logger;

    /**
     * @inheritDoc
     */
    @Override
    public AbstractLogger pluginLogger() {
        return new VelocityLogger(logger);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerHooks() {
        // Register LuckPerms hook
        if (server.getPluginManager().getPlugin("LuckPerms").isPresent()) {
            useLogger("LuckPerms detected, enabling LuckPerms hook.");
            TaterLib.addHook(new LuckPermsHook());
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerEventListeners() {
        EventManager eventManager = server.getEventManager();

        // Register player listeners
        eventManager.register(this, new VelocityPlayerListener());

        // Register server listeners
        ServerListener.onServerStarted();
        eventManager.register(this, new VelocityServerListener());
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerCommands() {
        CommandManager commandManager = server.getCommandManager();
        commandManager.register(TaterLibCommand.getCommandName(), new VelocityTaterLibCommand());
    }

    /**
     * Called when the proxy is initialized.
     * @param event The event.
     */
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxyServer = server;
        pluginStart();
    }

    /**
     * Called when the proxy is shutting down.
     * @param event The event.
     */
    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        ServerListener.onServerStopped();
        pluginStop();
    }
}
