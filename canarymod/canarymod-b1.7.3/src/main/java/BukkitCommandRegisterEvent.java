/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.command.Command;
import dev.neuralnexus.taterapi.event.command.CommandRegisterEvent;

/** Bukkit implementation of {@link CommandRegisterEvent}. */
public class BukkitCommandRegisterEvent implements CommandRegisterEvent {
    @Override
    public void registerCommand(Command command, String... aliases) {
    	etc.getInstance().addCommand(command.name(), command.description());
    }
}
