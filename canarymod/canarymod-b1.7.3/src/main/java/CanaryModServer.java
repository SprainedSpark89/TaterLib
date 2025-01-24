/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.io.File;

/** CanaryMod implementation of {@link Server}. */
public class CanaryModServer implements dev.neuralnexus.taterapi.server.Server {
    private static final CanaryModServer instance = new CanaryModServer();

    public static CanaryModServer instance() {
        return instance;
    }

    @Override
    public String brand() {
        throw new VersionFeatureNotSupportedException();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
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
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("#") || line.equals("") || line.startsWith("﻿")) {
                    continue;
                }
                etc.getInstance();
				array.add(etc.getDataSource().getPlayer(line));
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public List worlds() {
    	List<World> worlds = new ArrayList<World>();
    	worlds.add(etc.getServer().getWorld(0));
    	worlds.add(etc.getServer().getWorld(-1));
        return worlds;
    }
}
