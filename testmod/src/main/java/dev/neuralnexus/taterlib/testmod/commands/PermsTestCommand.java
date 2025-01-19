/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.testmod.commands;

import dev.neuralnexus.modapi.crossperms.api.PermsAPI;
import dev.neuralnexus.modapi.metadata.MetaAPI;
import dev.neuralnexus.modapi.metadata.Platforms;
import dev.neuralnexus.modapi.metadata.impl.util.TextUtil;
import dev.neuralnexus.taterapi.command.Command;
import dev.neuralnexus.taterapi.command.CommandSender;
import dev.neuralnexus.taterapi.entity.player.Player;
import dev.neuralnexus.taterlib.testmod.TestMod;
import dev.neuralnexus.taterlib.testmod.api.TestModAPIProvider;

import java.lang.reflect.InvocationTargetException;

/** Example Command. */
public class PermsTestCommand implements Command {
    private String name = "permstest";

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String description() {
        return "Permissions Test command";
    }

    @Override
    public String usage() {
        return "/permstest";
    }

    @Override
    public String permission() {
        return "testmod.command.permstest";
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        //        if (!sender.hasPermission(permission())) {
        //            sender.sendMessage(
        //                    TextUtil.substituteSectionSign(
        //                            "&cYou do not have permission to execute this command!"));
        //            return true;
        //        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(
                    TextUtil.substituteSectionSign(
                            "&cThis command can only be executed by a player!"));
            return true;
        }

        // Reflect to get `CommandSender#sender` Object
        Object senderObj = sender;
        if (MetaAPI.instance().isPlatformPresent(Platforms.BUKKIT)) {
            try {
                senderObj = sender.getClass().getDeclaredMethod("player").invoke(sender);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try {
            if (PermsAPI.instance().hasPermission(senderObj, 4)) {
                sender.sendMessage("INT PERMISSIONS WORK");
            } else {
                sender.sendMessage("INT PERMISSIONS DO NOT WORK");
            }
            if (PermsAPI.instance().hasPermission(senderObj, this.permission())) {
                sender.sendMessage("STRING PERMISSIONS WORK");
            } else {
                sender.sendMessage("STRING PERMISSIONS DO NOT WORK");
            }
        } catch (Exception e) {
            TestMod.logger().info("Error: ");
            e.printStackTrace();
        }

        sender.sendMessage(TextUtil.substituteSectionSign(TestModAPIProvider.get().getSomeData()));
        return true;
    }
}
