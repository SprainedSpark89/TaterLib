/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.mixin.v1_12_2.forge.api.minecraft.server;

import dev.neuralnexus.conditionalmixins.annotations.ReqMCVersion;
import dev.neuralnexus.conditionalmixins.annotations.ReqPlatform;
import dev.neuralnexus.taterapi.MinecraftVersion;
import dev.neuralnexus.taterapi.Platform;
import dev.neuralnexus.taterapi.entity.player.SimplePlayer;
import dev.neuralnexus.taterapi.server.Server;
import dev.neuralnexus.taterapi.world.ServerWorld;
import dev.neuralnexus.taterlib.v1_12_2.forge.player.ForgePlayer;
import dev.neuralnexus.taterlib.v1_12_2.forge.world.ForgeServerWorld;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.WorldServer;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ReqPlatform(Platform.FORGE)
@ReqMCVersion(min = MinecraftVersion.V1_12, max = MinecraftVersion.V1_12_2)
@Mixin(MinecraftServer.class)
@Implements(@Interface(iface = Server.class, prefix = "server$", remap = Interface.Remap.NONE))
public abstract class MinecraftServerAPI {
    @Shadow
    public abstract String shadow$getServerModName();

    @Shadow
    public abstract PlayerList shadow$getPlayerList();

    @Shadow
    public abstract Iterable<WorldServer> shadow$getAllLevels();

    public String server$brand() {
        return shadow$getServerModName();
    }

    public List<SimplePlayer> server$onlinePlayers() {
        return shadow$getPlayerList().getPlayers().stream()
                .map(ForgePlayer::new)
                .collect(Collectors.toList());
    }

    public List<ServerWorld> server$worlds() {
        List<ServerWorld> worlds = new ArrayList<>();
        shadow$getAllLevels().forEach(world -> worlds.add(new ForgeServerWorld(world)));
        return worlds;
    }
}
