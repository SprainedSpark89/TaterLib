package dev.neuralnexus.taterlib.v1_20.sponge;

import dev.neuralnexus.taterlib.TaterLib;
import dev.neuralnexus.taterlib.TaterLibPlugin;
import dev.neuralnexus.taterlib.api.TaterAPI;
import dev.neuralnexus.taterlib.api.TaterAPIProvider;
import dev.neuralnexus.taterlib.api.info.PluginInfo;
import dev.neuralnexus.taterlib.api.info.ServerType;
import dev.neuralnexus.taterlib.logger.LoggerAdapter;
import dev.neuralnexus.taterlib.utils.VanillaServerReflect;
import dev.neuralnexus.taterlib.v1_20.sponge.hooks.permissions.SpongePermissionsHook;
import dev.neuralnexus.taterlib.v1_20.sponge.listeners.command.SpongeCommandListener;

import org.spongepowered.api.Sponge;
import org.spongepowered.plugin.PluginContainer;

import java.util.stream.Collectors;

public class SpongeTaterLibPlugin implements TaterLibPlugin {
    private PluginContainer container;

    @Override
    public void platformInit(Object plugin, Object logger) {
        container = (PluginContainer) plugin;
        TaterAPIProvider.addHook(new SpongePermissionsHook());
        pluginStart(container, new LoggerAdapter(TaterLib.Constants.PROJECT_ID, logger));
        TaterAPI api = TaterAPIProvider.get(ServerType.SPONGE);
        api.setPluginList(
                () ->
                        Sponge.pluginManager().plugins().stream()
                                .map(
                                        pluginContainer ->
                                                new PluginInfo(
                                                        pluginContainer.metadata().id(),
                                                        pluginContainer
                                                                .metadata()
                                                                .version()
                                                                .toString()))
                                .collect(Collectors.toSet()));
        api.setServer(VanillaServerReflect::instance);
    }

    @Override
    public void platformEnable() {
        Sponge.eventManager().registerListeners(container, new SpongeCommandListener());
    }

    @Override
    public void platformDisable() {
        pluginStop();
    }
}
