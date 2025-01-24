/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.command.CommandSender;

import java.util.UUID;

/** CanaryMod implementation of {@link CommandSender} */
public class CanaryModCommandSender implements CommandSender {
    

    

    /**
     * Get the sender
     *
     * @return The sender
     */
    
    @Override
    public UUID uuid() {
        return new UUID(0, 0);
    }

    @Override
    public String name() {
        return "Console";
    }

    @Override
    public void sendMessage(String message) {
    	String[] messageAsArg = new String[1];
    	messageAsArg[0] = message;
        ServerConsoleCommands.parseServerConsoleCommand(null, "say", messageAsArg);
    }

    @Override
    public boolean hasPermission(int permissionLevel) {
        return true;
    }

    @Override
    public boolean hasPermission(String permission) {
        return true;
    }
}
