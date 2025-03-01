/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_9_4.forge.command;

import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.command.Command;
import dev.neuralnexus.taterapi.command.CommandSender;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;

import java.util.UUID;

/** Forge implementation of {@link CommandSender} */
public class ForgeSender implements CommandSender {
    private final ICommandSender sender;
    private final Command command;

    public ForgeSender(ICommandSender sender, Command command) {
        this.sender = sender;
        this.command = command;
    }

    /**
     * Get the sender
     *
     * @return The sender
     */
    public ICommandSender sender() {
        return sender;
    }

    @Override
    public UUID uuid() {
        return new UUID(0, 0);
    }

    @Override
    public String name() {
        return sender.getName();
    }

    @Override
    public void sendMessage(String message) {
        sender.addChatMessage(new TextComponentString(message));
    }

    @Override
    public boolean hasPermission(int permissionLevel) {
        return sender.canCommandSenderUseCommand(permissionLevel, command.name());
    }

    @Override
    public boolean hasPermission(String permission) {
        return TaterAPIProvider.hasPermission(this, permission);
    }
}
