/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.mixin.v1_20.fabric.api.minecraft.commands;

import dev.neuralnexus.modapi.metadata.Mappings;
import dev.neuralnexus.modapi.metadata.enums.MinecraftVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMCVersion;
import dev.neuralnexus.modapi.muxins.annotations.ReqMappings;
import dev.neuralnexus.taterapi.command.CommandSender;
import dev.neuralnexus.taterapi.entity.Permissible;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Interface.Remap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@ReqMappings(Mappings.YARN_INTERMEDIARY)
@ReqMCVersion(min = MinecraftVersion.V20, max = MinecraftVersion.V20_6)
@Mixin(CommandSourceStack.class)
@Implements({
    @Interface(iface = CommandSender.class, prefix = "cmdSender$", remap = Remap.NONE),
    @Interface(iface = Permissible.class, prefix = "permissible$", remap = Remap.NONE)
})
public abstract class CommandSourceStack_API {
    @Shadow
    public abstract String shadow$getTextName();

    @Shadow
    public abstract void shadow$sendSystemMessage(Component message);

    @Shadow
    @Nullable public abstract Entity shadow$getEntity();

    @Shadow
    public abstract boolean shadow$hasPermission(int permissionLevel);

    public String cmdSender$name() {
        return this.shadow$getTextName();
    }

    public void cmdSender$sendMessage(String message) {
        this.shadow$sendSystemMessage(Component.nullToEmpty(message));
    }

    @SuppressWarnings("DataFlowIssue")
    public UUID permissible$uuid() {
        if (this.shadow$getEntity() == null) {
            return new UUID(0, 0);
        }
        return this.shadow$getEntity().getUUID();
    }

    public boolean permissible$hasPermission(int permissionLevel) {
        return this.shadow$hasPermission(permissionLevel);
    }
}
