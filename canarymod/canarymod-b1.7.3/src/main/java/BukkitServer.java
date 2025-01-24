/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.player.SimplePlayer;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.world.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.io.File;

/** Bukkit implementation of {@link Server}. */
public class BukkitServer implements dev.neuralnexus.taterapi.server.Server {
    private static final BukkitServer instance = new BukkitServer();

    public static BukkitServer instance() {
        return instance;
    }

    @Override
    public String brand() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public List onlinePlayers() {
        return etc.getServer().getPlayerList();
    }

    @Override
    public Map<String, UUID> whitelist() {
        Map<String, UUID> whitelist = new HashMap<>();
        for (Player player : getWhitelist()) {
            whitelist.put(player.getName(), new UUID(0, 0));
        }
        return whitelist;
    }
    
    public ArrayList<Player> getWhitelist() {
    	String location = etc.getInstance().getWhitelistLocation();
        ArrayList<Player> array = new ArrayList<Player>();
        try {
            Scanner scanner = new Scanner(new File(location));
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("#") || line.equals("") || line.startsWith("﻿")) {
                    continue;
                }
                etc.getInstance();
				array.add(etc.getDataSource().getPlayer(line));
                i++;
            }
            scanner.close();
        } catch (Exception e) {
            //log.log(Level.SEVERE, "Exception while reading " + location, e);
        }
        return array;
    }

    @Override
    public Map<String, UUID> playercache() {
        // TODO: Find some alternative
        return Collections.emptyMap();
    }

    @Override
    public List worlds() {
    	List<World> worlds = new ArrayList<World>();
    	worlds.add(etc.getServer().getWorld(0));
    	worlds.add(etc.getServer().getWorld(-1));
        return worlds;
    }
}
