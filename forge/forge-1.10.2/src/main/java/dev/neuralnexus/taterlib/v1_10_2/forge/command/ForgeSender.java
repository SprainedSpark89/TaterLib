package dev.neuralnexus.taterlib.v1_10_2.forge.command;

import dev.neuralnexus.taterlib.command.Command;
import dev.neuralnexus.taterlib.command.CommandSender;
import java.util.UUID;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;

/** Bukkit implementation of {@link CommandSender} */
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

    /** {@inheritDoc} */
    @Override
    public UUID uuid() {
        return new UUID(0, 0);
    }

    /** {@inheritDoc} */
    @Override
    public String name() {
        return sender.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void sendMessage(String message) {
        sender.sendMessage(new TextComponentString(message));
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasPermission(int permissionLevel) {
        return sender.canUseCommand(permissionLevel, command.name());
    }
}
