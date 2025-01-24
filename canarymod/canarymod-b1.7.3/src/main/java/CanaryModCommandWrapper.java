/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.command.Command;

/** Wraps a command callback into a CanaryMod CommandExecutor. */
public class CanaryModCommandWrapper extends PluginListener {
    private final Command command;

    public CanaryModCommandWrapper(Command command) {
        this.command = command;
    }
    
    public CanaryModCommandWrapper() {
		this.command = null;
	}

	public boolean onCommand(Player player, String[] split) {
        return command.execute(new CanaryModPlayer(player), split[0], removeFirst(split));
    }
    
    public boolean onConsoleCommand(String[] split) {
    	return command.execute(new CanaryModCommandSender(), split[0], removeFirst(split));
    }
    
    public static String[] removeFirst(String[] input) {
        // Check if the input array is null or empty
        if (input == null || input.length == 0) {
            return new String[0]; // Return an empty array
        }

        // Create a new array with a size one less than the input array
        String[] result = new String[input.length - 1];

        // Copy the elements starting from index 1 of the input array to the new array
        System.arraycopy(input, 1, result, 0, result.length);

        return result;
    }

    /*@Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender instanceof Player) {
            return command.execute(new CanaryModPlayer((Player) sender), label, args);
        }
        return command.execute(new CanaryModCommandSender(sender), label, args);
    }*/
}
